package com.audio.electric.controller;

import com.audio.electric.domain.Apk;
import com.audio.electric.domain.EnumValue;
import com.audio.electric.service.IApkService;
import com.audio.electric.service.IDictService;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * 用于对apk的管理
 * @author albert
 * @time 2016年9月10日
 */
@Controller
@RequestMapping("/apk")
public class ApkController extends BaseController{
	@Resource
	private IApkService apkService;
	@Autowired
	private IDictService dictService;
	/**
	 * 显示增加apk文件的信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showApkEdit")
	public String showAddApk(HttpServletRequest request , Model model) throws Exception {
		List<EnumValue> appType = dictService.listEnumValueByTitle(Constant.APKTYPE);
		model.addAttribute("appType",appType);
		model.addAttribute("requestUrl","/apk/uploadApk");
		return "apk/apk_edit";
	}
	/**
	 * 分页获取apk历史信息
	 * @param apk
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/apkList")
	public String obtainPageApk(Apk apk ,Model model) throws Exception {
		//获取apk历史信息
		List<Apk> apks = apkService.listApk(apk);
		//获取歌手类型的所有数据
		List<EnumValue> appType = dictService.listEnumValueByTitle(Constant.APKTYPE);
		PageInfo pagehelper = new PageInfo(apks);
		model.addAttribute("pagehelper",pagehelper);
		model.addAttribute("apkList",apks);
		model.addAttribute("appType",appType);
		return "apk/apk_list";
	}
	/**
	 * 上传apk文件以及保存apk文件信息
	 * @param apkFile
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/uploadApk")
	public Object uploadApkFile(@RequestParam MultipartFile apkFile, Apk apk ,HttpServletRequest request) throws Exception {
		int result ;
		if(apkFile!=null){
			if(!apkFile.getOriginalFilename().toLowerCase().endsWith("apk")){
				throw new PlatException(RetCode.MULTIPARTFILENOTEXIST);
			}
		}
		//获取携带其它参数
		//保存apk及相关信息
		saveApkFile(apkFile,apk);
		//增加apk版本信息

		result = apkService.addApkHistory(apk);
		return BodyUtil.result(result);
	}
	/**
	 * 删除APK版本操作
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteApk")
	public Object deleteApk(String ids) throws Exception {
		int result = apkService.deleteApk(ids);
		return BodyUtil.result(result);
	}

	/**
	 * 保存歌曲音频文件
	 * @param headerFile
	 * @param apk
	 * @throws Exception
	 */
	private void saveApkFile(@RequestParam MultipartFile headerFile, Apk apk) throws Exception {
		//获取音频文件保存的路径
		String pathName = Tools.propertiesFileResolve(Constant.APKFILELOCATION);
		String datePath = DateUtil.getCurDatePath();
		logger.info("datePath={}",datePath);
		pathName += datePath;
		//服务器文件读取地址
		String serverPath = Tools.propertiesFileResolve(Constant.SERVERLOCATION);

		String headerFileName = Tools.fileRename(headerFile.getOriginalFilename());
		//设置文件名
		apk.setApkName(headerFileName);
		//设置文件前缀路径
		apk.setApkPath(pathName);
		//设置服务器地址
		apk.setServerUrl(serverPath);

		//处理文件上传的路径
		File directory = new File(pathName);
		if(!directory.exists()){
			directory.mkdirs();
		}
		pathName += headerFileName;
		//复制文件
		headerFile.transferTo(new File(pathName));
	}
}