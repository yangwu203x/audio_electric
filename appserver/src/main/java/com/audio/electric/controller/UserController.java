package com.audio.electric.controller;

import com.audio.electric.domain.User;
import com.audio.electric.service.IUserService;
import com.audio.electric.util.constants.Constant;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.DateUtil;
import com.audio.electric.util.tool.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 * Created by yangwu on 2017/3/15.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;


    /**
     * 修改个人信息
     */
    public Object userInfo(User user){
        int result = userService.userInfo(user);
        return BodyUtil.result(result);
    }

    /**
     * 修改头像
     * @param headerFile
     * @return
     * @throws Exception
     */
    @PostMapping("/headerModify")
    public String headerModify(@RequestParam MultipartFile headerFile) throws Exception {
        if (headerFile != null) {
            if (!validateFile(headerFile.getOriginalFilename())) {
                return null;
            }
        }
        String pathName = Tools.propertiesFileResolve(Constant.HEADERFILELOCATION);
        String datePath = DateUtil.getCurDatePath();
        pathName += datePath;
        File directory = new File(pathName);
        if(!directory.exists()){
            directory.mkdirs();
        }

        String fileName = Tools.obtainFileName(headerFile.getOriginalFilename());
        headerFile.transferTo(new File(pathName+ Constant.FILE_SEPLATOR + headerFile.getOriginalFilename()));
        return null;
    }

    /**
     * 验证文件
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    private boolean validateFile(String fileName) throws Exception {
        if (!fileName.toLowerCase().endsWith("jpg") && !fileName.toLowerCase().endsWith("png")
                && !fileName.toLowerCase().endsWith("jepg")) {
            return false;
        }
        return true;
    }


}
