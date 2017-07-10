package com.audio.electric.controller;

import com.alibaba.fastjson.JSON;
import com.audio.electric.domain.Account;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.*;
import com.audio.electric.util.upload.IoUtil;
import com.audio.electric.domain.EnumValue;
import com.audio.electric.domain.Range;
import com.audio.electric.domain.Song;
import com.audio.electric.service.IDictService;
import com.audio.electric.service.ISongService;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.excelUtil.ExcelUtil;
import com.audio.electric.util.upload.StreamException;
import com.audio.electric.util.usbkey.HMAC_MD5;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.CellType;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 歌曲管理的controller
 * 
 * @author albert
 * @time 2016年9月10日
 */
@Controller
@RequestMapping("/song")
public class SongController extends BaseController {
	@Autowired
	private ISongService songService;
	@Autowired
	private IDictService dictService;

	/**
	 * 显示歌曲信息列表
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/listSong")
	public String listSong(Model model,Song song) throws Exception {
		List<Song> songList = songService.listSong(song);
		PageInfo pagehelper = new PageInfo(songList);
		model.addAttribute("pagehelper",pagehelper);
		// 添加模型数据
		model.addAttribute("songList", songList);
		return "song/song_list";
	}



	/**
	 * 跳到增加或修改歌曲信息页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showSongEdit")
	public String showSongEdit(String operateType ,Model model ,Song song) throws Exception {
		// 准备视图数据对象
		// 获取要访问的视图
		String viewName = "song/song_edit";
		// 获取所有的歌曲主题信息
		List<EnumValue> songTheme = dictService.listEnumValueByTitle(Constant.SONGTHEMES);
		List<EnumValue>  songType = dictService.listEnumValueByTitle(Constant.SONGTYPES);
		List<EnumValue>  songLang = dictService.listEnumValueByTitle(Constant.SONGLANGS);
		model.addAttribute("songThemes", songTheme);
		model.addAttribute("songTypes", songType);
		// 获取所有歌曲语种信息
		model.addAttribute("songLangs", songLang);
		// 如果请求是前往编辑歌曲页面
		if (("2").equals(operateType)) {
			// 获取修改歌曲的编号
			// 执行数据库操作
			song = songService.findSingleSong(song);
			model.addAttribute("song", song);
			model.addAttribute("edit","edit");
		} else {
		}
		model.addAttribute("requestUrl", "/song/editSong");
		// 设置视图
		return viewName;
	}

	/**
	 * 验证文件
	 *
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	private boolean validateFile(String fileName) throws Exception {
		if (!fileName.toLowerCase().endsWith("mpg") && !fileName.toLowerCase().endsWith("mkv")
				&& !fileName.toLowerCase().endsWith("mrs")) {
			return false;
		}
		return true;
	}

	/**
	 * 增加歌曲信息或者修改歌曲信息
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/editSong")
	public Object addSong(@RequestParam(value="songFile", required = false) MultipartFile songFile, HttpServletRequest request,Song song) throws Exception {
		if (songFile != null) {
			if (!validateFile(songFile.getOriginalFilename())) {
				throw new PlatException(RetCode.UPLOADFILENOTILLEGAL);
			}
			// 获取新增加的歌曲编号或者是修改后的歌曲编号
			String songNo = request.getParameter("songNo");
			String fileName = Tools.obtainFileName(songFile.getOriginalFilename());
			if (songNo == null || !songNo.equals(fileName)) {
				throw new PlatException(RetCode.UPLOADFILENOTEQUALSONGID);
			}
			//保存音频文件
			saveSongFile(songFile,song);
		}
		//去掉最后的字符"/"
		song.setSongZs(song.getSongName().length());
		song.setSingerName(song.getSingerName().substring(0,song.getSingerName().length()-1));
		if (song.getId() != null) {
			// 修改歌曲
			return BodyUtil.result(songService.updateSong(song));
		}
		// 增加歌曲
		return BodyUtil.result(songService.addSong(song));
	}

	/**
	 * 修改不带文件歌曲信息
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateSongOther")
	public Object updateSong(HttpServletRequest request,Song song) throws Exception {
		// 准备封装数据的对象
		// 获取歌曲相关信息 如果这个值存在则为修改
		String oldSongId = request.getParameter("oldSongId");
		// 获取新增加的歌曲编号或者是修改后的歌曲编号
		String songId = request.getParameter("songId");
		if (!oldSongId.equals(songId)) {
			// 没有修改歌曲就不允许修改歌曲编号
			return false;
		}
		// 增加歌曲
		return songService.updateSong(song);
	}

	/**
	 * 显示歌曲歌星排行信息
	 */
	@RequestMapping("/showRank")
	public String showRanking(Model model) throws Exception {
		List<Song> rankingList = songService.rankList();
		// 添加模型数据
		model.addAttribute("rankList", rankingList);
		return "rank_list";
	}

	/**
	 * 删除歌曲操作
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteSong")
	public Object deleteSong(String ids) throws Exception {
		return BodyUtil.result(songService.deleteSong(ids));
	}

	/**
	 * 审核
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/passCheck")
	public Object passCheck(Song song) throws Exception {
		return songService.updateStatus(song);
	}

	/**
	 * 自动补全功能
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/autoSearch")
	public Object autoSearch(Song song) throws Exception {
		List<String> result = songService.autoSearch(song);
		return JSON.toJSON(result).toString();
	}

	/**
	 * 备份歌曲表操作
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/backupSong")
	public Object backupSong() throws Exception {
		boolean result = false;
		InputStream stream = this.getClass().getResourceAsStream(Constant.BACKUPPROLOCATION);
		Properties prop = new Properties();
		prop.load(stream);
		try {
			String dbSongPath = prop.getProperty("dbSongPath");
			stream.close();
			String tableName = "dbSongs";
			DbOperate.tableBackup(dbSongPath, tableName);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 还原歌曲表操作
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/restoreSong")
	public Object restoreSong() throws Exception {
		boolean result = false;
		InputStream stream = this.getClass().getResourceAsStream(Constant.BACKUPPROLOCATION);
		Properties prop = new Properties();
		prop.load(stream);
		try {
			String dbSongPath = prop.getProperty("dbSongPath");
			stream.close();
			DbOperate.dbRecover(dbSongPath);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

//	@RequestMapping("/obtainRandom")
//	@ResponseBody
//	public int obtainRandom(HttpServletRequest request,Model model){
//		//获取账户id
//		Account account = (Account) request.getSession().getAttribute(Constant.CURRENT_LOGIN_ACCOUNT);
//		//获取账户的pid和USER PIN 码，传到页面上
//		model.addAttribute("USERPIN",account.getUserPin());
//		model.addAttribute("PID",account.getPid());
//		Random random = new Random();
//		int num = random.nextInt();//随机数
//		String code = HMAC_MD5.ecrpt(account.getKeyt(),num + "");
//		request.getSession().setAttribute(Constant.KEY_NAME,code);
//		return num;
//	}

	@RequestMapping("/toExportHtml")
	public String toExportHtml(HttpServletRequest request,Model model){
		Account account = (Account) request.getSession().getAttribute(Constant.CURRENT_LOGIN_ACCOUNT);
		//获取账户的pid和USER PIN 码，传到页面上
		model.addAttribute("USERPIN",account.getUserPin());
		model.addAttribute("PID",account.getPid());
		Random random = new Random();
		int num = random.nextInt();//随机数
		String code = HMAC_MD5.ecrpt(account.getKeyt(),num + "");
		request.getSession().setAttribute(Constant.KEY_NAME,code);
		model.addAttribute("NUM",num);
		return "song/confirm";
	}

	/**
	 * 导出歌曲数据至excel
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exportToExcel")
	public void exportData(HttpServletResponse response,HttpServletRequest request ,String ePassDigest) throws Exception {
		//校验密码
		String code = (String) request.getSession().getAttribute(Constant.KEY_NAME);
		if(ePassDigest == null || !ePassDigest.equals(code))
			throw new PlatException(RetCode.PARAMETER_ERROR);
		response.setHeader("Content-disposition", "attachment; filename=song.xls");
		response.setContentType("application/msexcel");
		OutputStream output = response.getOutputStream();
		songService.exportSong(output);

	}

	/**
	 * 导入歌曲数据至数据库
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/importFromExcel")
	public Object importData(@RequestParam MultipartFile excelFile) {

		return songService.addSongList(excelFile);
	}

	/**
	 * 下载模板文件
	 *
	 * @param
	 */
	@RequestMapping("/templateDownload")
	public void templateDownload(HttpServletResponse response) throws Exception {
		//获取要导出的数据
		List<Song> songs = songService.listSong(new Song());
		response.setHeader("Content-disposition", "attachment; filename=song.xls");
		response.setContentType("application/msexcel");

		// 获取流
		OutputStream output = response.getOutputStream();
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", "歌曲信息表");
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "web-info-template1.xls", output,
				songs, Song.class, true);
	}

	/**
	 * 仅单个文件上传
	 *
	 * @param songFile
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/uploadSongFile")
	public Object uploadSongFile(@RequestParam MultipartFile songFile, HttpServletRequest request ,Song song) throws Exception {
		// 验证文件的合法性
		if (songFile != null) {
			if (!validateFile(songFile.getOriginalFilename())) {
				throw new PlatException(RetCode.UPLOADFILENOTILLEGAL);
			}
		}
		// 获取歌曲编号
		String songId = request.getParameter("songId");
		String fileName = Tools.obtainFileName(songFile.getOriginalFilename());
		if (!songId.equals(fileName)) {
			return false;
		}
		saveSongFile(songFile,song);
		// 增加歌曲文件
		return songService.updateSong(song);
	}

	/**
	 * 保存歌曲音频文件
	 * @param headerFile
	 * @param song
	 * @throws Exception
	 */
	private void saveSongFile(@RequestParam MultipartFile headerFile, Song song) throws Exception {
		//获取音频文件保存的路径
		String pathName = Tools.propertiesFileResolve(Constant.SONGFILELOCATION);
		String datePath = DateUtil.getCurDatePath();
		logger.info("datePath={}",datePath);
		pathName += datePath;
		//服务器文件读取地址
		String serverPath = Tools.propertiesFileResolve(Constant.SERVERLOCATION);

		String headerFileName = headerFile.getOriginalFilename();
		//设置文件名
		song.setHeaderPath(headerFileName);
		//设置文件前缀路径
		song.setPrefixPath(pathName);
		//设置服务器地址
		song.setServerUrl(serverPath);

		//处理文件上传的路径
		File directory = new File(pathName);
		if(!directory.exists()){
			directory.mkdirs();
		}
		pathName += headerFileName;
		//复制文件
		headerFile.transferTo(new File(pathName));
	}


	/**
	 * 批量上传歌曲文件
	 *
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/batchUpload")
	public void batchUploadFile(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 获取文件名
		String fileName = req.getParameter("name");
		if (fileName != null) {
			if (!validateFile(fileName)) {
				return;
			}
		}
		// 设置请求头
		doOptions(req, resp);
		// 获取口令
		String token = req.getParameter("token");
		// 获取歌曲文件保存路径
		String absolutePath = Tools.propertiesFileResolve(Constant.SONGFILELOCATION);
		String datePath = DateUtil.getCurDatePath();
		// 分析请求头数据
		Range range = IoUtil.parseRange(req);
		OutputStream out = null;
		InputStream in = null;
		PrintWriter writer = resp.getWriter();
		JSONObject json = new JSONObject();
		long start = 0L;
		boolean success = true;
		String message = "";
		//待保存的文件目录
		String saveFileDir = absolutePath + datePath;
		 // 生成上传的文件片段
		File f = IoUtil.getTokenedFile(saveFileDir, token);
		try {
			if (f.length() != range.getFrom()) {
				throw new PlatException(RetCode.UPLOADEXCEPTION);
			}
			out = new FileOutputStream(f, true);
			in = req.getInputStream();
			int read = 0;
			byte[] bytes = new byte[10240];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			start = f.length();
		} catch (StreamException se) {
			success = StreamException.ERROR_FILE_RANGE_START == se.getCode();
			message = "Code: " + se.getCode();
		} catch (FileNotFoundException fne) {
			message = "Code: " + StreamException.ERROR_FILE_NOT_EXIST;
			success = false;
		} catch (IOException io) {
			message = "IO Error: " + io.getMessage();
			success = false;
		} finally {
			// 关闭输入输出流
			IoUtil.close(out);
			IoUtil.close(in);
			if (range.getSize() == start) {
				// 保存最终文件的文件句柄
				File destFile = new File(saveFileDir+Constant.FILE_SEPLATOR + fileName);
				// 先清除该文件对象中的数据
				destFile.delete();
				/**
				 * mv 	move
				 */
				// 重新将文件片段保存
				f.renameTo(destFile);
				// 释放内存
				f = null;
				destFile = null;
				// 进行数据库操作
				if (start != 0) {
					// 获取歌曲的文件名
					Song song = new Song();
					song.setHeaderPath(fileName);
					song.setPrefixPath(saveFileDir);
					song.setServerUrl(Tools.propertiesFileResolve(Constant.SERVERLOCATION));
					// 获取文件名不包含后缀名
					song.setSongNo(Tools.obtainFileName(fileName));
					songService.updateSong(song);
					range = null;
				}
			}
			try {
				if (success)
					json.put("start", start);
				json.put("success", success);
				json.put("message", message);
			} catch (JSONException localJSONException3) {
			}
			writer.write(json.toString());
			IoUtil.close(writer);
		}
	}

	/**
	 * 设置请求头参数
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Range,Content-Type");
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
	}

	@RequestMapping("/showUpload")
	public String showFileUpload() {
		return "song/uploadFile";
	}

	/**
	 * 根据歌曲名去获取可能的歌曲编号
	 *
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/obtainSongIdByName")
	public Object obtainSongIdByName(Song song) throws Exception {
		// 获取可能的编号
		List<String> singerIds = songService.obtainSongIdByName(song);
		return singerIds;
	}

}
