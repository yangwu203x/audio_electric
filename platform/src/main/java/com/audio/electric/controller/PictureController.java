package com.audio.electric.controller;

import com.audio.electric.domain.Picture;
import com.audio.electric.service.IPictureService;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.DateUtil;
import com.audio.electric.util.tool.Tools;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/4 0004 14:53
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private IPictureService pictureService;

    @RequestMapping("/listBackground")
    public String listBackground(Model model){
        List<Picture> pictureList = pictureService.listBackground();
        PageInfo<Picture> pagehelper = new PageInfo<>(pictureList);
        model.addAttribute("pictureList",pictureList);
        model.addAttribute("pagehelper",pagehelper);
        return "picture/picture_list";
    }

    @RequestMapping("/addPicture")
    public String addPicture(Model model){
        model.addAttribute("requestUrl","/picture/modifyPicture");
        return "picture/picture_add";
    }

    @RequestMapping("/editPicture")
    public String editPicture(Integer id,Model model){
        Picture picture = pictureService.getPictureById(id);
        model.addAttribute("picture",picture);
        model.addAttribute("requestUrl","/picture/modifyPicture");
        return "picture/picture_add";
    }

    @RequestMapping("/savePicture")
    @ResponseBody
    public Object savePicture(@RequestParam MultipartFile pictureFile,Picture picture) throws Exception {
        if(pictureFile!=null){
            if(!pictureFile.getOriginalFilename().toLowerCase().endsWith("jpg")
                    && !pictureFile.getOriginalFilename().toLowerCase().endsWith("jpeg")
                    && !pictureFile.getOriginalFilename().toLowerCase().endsWith("png")
                    && !pictureFile.getOriginalFilename().toLowerCase().endsWith("bmp")){
                throw new PlatException(RetCode.MULTIPARTFILENOTEXIST);
            }
            savePictureFile(pictureFile,picture);
        }
        int result = pictureService.savePicture(picture);
        return BodyUtil.result(result);
    }

    private void savePictureFile(@RequestParam MultipartFile headerFile, Picture picture) throws Exception {
        //获取音频文件保存的路径
        String pathName = Tools.propertiesFileResolve(Constant.STARTPICTURE);
        String datePath = DateUtil.getCurDatePath();
        logger.info("datePath={}",datePath);
        pathName += datePath;
        //服务器文件读取地址
        String serverPath = Tools.propertiesFileResolve(Constant.SERVERLOCATION);

        String name = Tools.fileRename(headerFile.getOriginalFilename());
        //设置文件名
        picture.setName(name);
        //设置文件前缀路径
        picture.setPath(pathName);
        //设置服务器地址
        picture.setServerUrl(serverPath);

        //处理文件上传的路径
        File directory = new File(pathName);
        if(!directory.exists()){
            directory.mkdirs();
        }
        pathName += name;
        //复制文件
        headerFile.transferTo(new File(pathName));
    }


}
