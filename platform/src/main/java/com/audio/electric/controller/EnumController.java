package com.audio.electric.controller;

import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.EnumValue;
import com.audio.electric.service.IDictService;
import com.audio.electric.util.protocol.BodyUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/26 0026 15:00
 */
@Controller
@RequestMapping("/enum")
public class EnumController extends BaseController{
    @Autowired
    private IDictService dictService;

    @GetMapping("/listDict")
    public String listDict(Model model){
        return "system/enum/enum_list";
    }

    @RequestMapping("/listEnumTypeByPage")
    public Object listEnumTypeByPage(Model model){
        List<EnumType> enumTypeList = dictService.listEnumType(new EnumType());
        PageInfo pagehelper = new PageInfo(enumTypeList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("enumTypeList",enumTypeList);
        return "system/enum/enum_type_list";
    }

    @RequestMapping("/listEnumType")
    @ResponseBody
    public Object listEnumType(){
        List<EnumType> dictList = dictService.listEnumType(new EnumType());
        return dictList;
    }

    @GetMapping("/showEnumType")
    public String showEnumType(EnumType enumType , Model model){
        String viewName = "system/enum/enum_add";
        //获取要访问的视图
        //添加
        model.addAttribute("requestUrl","/enum/addEnumType");
        return viewName;
    }

    @RequestMapping("/listEnumValue")
    public String listEnumValue(Integer enumTypeId,String title, Model model){
        String viewName = "system/enum/enum_value_list";
        List<EnumValue> enumValueList = dictService.listEValuePageByTypeId(enumTypeId);
        PageInfo pagehepler = new PageInfo(enumValueList);
        model.addAttribute("title",title);
        model.addAttribute("enumTypeId",enumTypeId);
        model.addAttribute("pagehelper",pagehepler);
        model.addAttribute("enumValueList",enumValueList);
        model.addAttribute("requestUrl","/enum/listEnumValue");
        return viewName;
    }

    @GetMapping("/showEnumValueEdit")
    public String showEnumValue(EnumValue enumValue , Model model, String operateType){
        String viewName = "system/enum/enum_value_edit";
        //获取要访问的视图
        if(("1").equals(operateType)){
            //添加
            model.addAttribute("requestUrl","/enum/addEnumValue");
            model.addAttribute("enumValue",enumValue);
            return viewName;
        }else if(("2").equals(operateType)){
            //修改
            enumValue = dictService.getEnumValue(enumValue);
            model.addAttribute("enumValue",enumValue);
            model.addAttribute("requestUrl","/enum/modifyEnumValue");
            return viewName;
        }
        //设置视图
        return "404";
    }

    @ResponseBody
    @RequestMapping("/getEnumValue")
    public Object getEnumValue(EnumValue enumValue){
        enumValue = dictService.getEnumValue(enumValue);
        return enumValue;
    }

    @ResponseBody
    @RequestMapping("/listEnumValueByTitle")
    public Object listEnumValueByTitle(String title){
        List<EnumValue> enumValueList = dictService.listEnumValueByTitle(title);
        return enumValueList;
    }

    @RequestMapping("/addEnumType")
    @ResponseBody
    public Object addEnumType(EnumType enumType){
        int result =  dictService.addEnumType(enumType);
        return BodyUtil.result(result);
    }

    @RequestMapping("/addEnumValue")
    @ResponseBody
    public Object addEnumValue(EnumValue enumValue){
        int result = dictService.addEnumValue(enumValue);
        return BodyUtil.result(result);
    }

    @RequestMapping("/modifyEnumType")
    @ResponseBody
    public Object modifyEnumType(EnumType enumType){
        int result = dictService.modifyEnumType(enumType);
        return BodyUtil.result(result);
    }

    @RequestMapping("/deleteEnumType")
    @ResponseBody
    public Object deleteEnumType(String ids){
        int result = dictService.deleteEnumType(ids);
        return BodyUtil.result(result);
    }

    @RequestMapping("/modifyEnumValue")
    @ResponseBody
    public Object modifyEnumValue(EnumValue enumValue){
        int result = dictService.modifyEnumValue(enumValue);
        return BodyUtil.result(result);
    }

    @RequestMapping("/deleteEnumValue")
    @ResponseBody
    public Object deleteEnumValue(String ids){
        int result = dictService.deleteEnumValue(ids);
        return BodyUtil.result(result);
    }
}
