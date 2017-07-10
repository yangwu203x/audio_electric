package com.audio.electric.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.audio.electric.domain.EnumValue;
import com.audio.electric.domain.Singer;
import com.audio.electric.service.IDictService;
import com.audio.electric.service.ISingerService;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.DateUtil;
import com.audio.electric.util.tool.Tools;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 歌手相关任务的controller
 * @author albert
 * @time 2016年9月14日
 */
@Controller
@RequestMapping("/singer")
public class SingerController extends BaseController{
	@Autowired
	private ISingerService singerService;
	@Autowired
	private IDictService dictService;
	/**
	 * 获取所有歌手的所有信息
	 * @param singer
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listSinger")
	public String listSinger(Singer singer , Model model){
		//执行数据获取操作
		List<Singer> singerList = singerService.listSinger(singer);
		//准备数据视图对象
		ModelAndView mv = new ModelAndView();
		//获取歌手类型的所有数据
		List<EnumValue> singerType = dictService.listEnumValueByTitle(Constant.SINGERTYPE);
		PageInfo pagehelper = new PageInfo(singerList);
		model.addAttribute("pagehelper",pagehelper);
		model.addAttribute("singerList",singerList);
		model.addAttribute("singerType", singerType);
		return "singer/singer_list";
	}
	/**
	 * 显示增加或修改歌手信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showSingerEdit")
	public String showSingerEdit(String operateType ,Singer singer,Model model) throws Exception {
		//获取要访问的视图
		 String viewName = "singer/singer_edit";
		 //获取歌手类型的所有数据
		List<EnumValue> singerType = dictService.listEnumValueByTitle(Constant.SINGERTYPE);
		 model.addAttribute("singerType", singerType);
		//如果请求是前往编辑歌曲页面
		 if(("2").equals(operateType)){
			 //获取修改歌手的编号
			 singer = singerService.getSinger(singer);
			 model.addAttribute("singer", singer);
			 model.addAttribute("requestUrl","/singer/updateSinger");
			 return viewName;
		 }else if ("1".equals(operateType)){
			 model.addAttribute("requestUrl","/singer/addSinger");
			 return viewName;
		 }
		//设置视图
		return "404";
	}
	private  boolean validateFile(String fileName) throws Exception {
		if(!fileName.endsWith("png")&&!fileName.endsWith("jpg")){
			return false;
		}
		return true;
	}
	/**
	 * 增加歌手信息
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/addSinger")
	public Object addSinger(@RequestParam MultipartFile headerFile,Singer singer, HttpServletRequest request) throws Exception {
		if(headerFile!=null){
			if(!validateFile(headerFile.getOriginalFilename())){
				throw new PlatException(RetCode.MULTIPARTFILENOTEXIST);
			}
			//保存头像
			saveHeaderFile(headerFile,singer);
		}
		//获取歌手字数及歌手的名字字符串长度
		singer.setSingerZs(singer.getSingerName().length());
		//增加歌手
		return BodyUtil.result(singerService.addSinger(singer));
	}


	/**
	 * 修改歌手信息和头像
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateSinger")
	public Object updateSinger(@RequestParam MultipartFile headerFile,Singer singer, HttpServletRequest request) throws Exception {
		if(headerFile!=null){
			if(!validateFile(headerFile.getOriginalFilename())){
				return false;
			}
			//修改头像
			saveHeaderFile(headerFile, singer);
		}
		//准备封装数据的对象
		//获取歌手字数及歌手的名字字符串长度
		singer.setSingerZs(singer.getSingerName().length());
		//修改歌手
		return BodyUtil.result(singerService.updateSinger(singer));
	}

	private void saveHeaderFile(@RequestParam MultipartFile headerFile, Singer singer) throws Exception {
		//获取头像文件保存的路径
		String pathName = Tools.propertiesFileResolve(Constant.HEADERFILELOCATION);
		String datePath = DateUtil.getCurDatePath();
		logger.info("datePath={}",datePath);
		pathName += datePath;
		//服务器文件读取地址
		String serverPath = Tools.propertiesFileResolve(Constant.SERVERLOCATION);

		String headerFileName = Tools.fileRename(headerFile.getOriginalFilename());
		//设置文件名
		singer.setHeaderPath(headerFileName);
		//设置文件前缀路径
		singer.setPrefixPath(pathName);
		//设置服务器地址
		singer.setServerUrl(serverPath);

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
	 * 修改歌手信息和头像
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/modifySinger")
	public Object updateSinger(HttpServletRequest request ,Singer singer) throws Exception {
		//修改歌手
		return singerService.updateSinger(singer);
	}
	/**
	 * 删除歌手操作
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("deleteSinger")
	public Object deleteSinger(HttpServletRequest request ,String ids) throws Exception {
		return singerService.deleteSinger(ids);
	} 
	/**
	 * 审核
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("passCheck")
	public Object passCheck(Singer singer) throws Exception {
		return BodyUtil.result(singerService.updateStatus(singer));
	}
	/**
	 * 自动补全功能
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/autoSearch")
	public String autoSearch(Singer singer)throws Exception {
		List<String> singerList = singerService.autoSearch(singer);
		return JSON.toJSON(singerList).toString();
	}
	
	/**
	 * 根据歌星名去获取可能的歌星编号
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/obtainIdByName")
	public Object obtainIdByName(Singer singer)throws Exception {
		//获取可能的编号
		List<Map<String,String>> singerIds=singerService.findIdByName(singer);
		return JSONObject.toJSON(singerIds);
	}

	/**
	 * 根据歌星名去获取可能的歌星编号
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/obtainIdById")
	public Object obtainIdById(String ids)throws Exception {
		//获取可能的编号
		List<Map<String,String>> singerIds = singerService.findIdById(ids);
		return JSONObject.toJSON(singerIds);
	}

}