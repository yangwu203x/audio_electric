package com.audio.electric.controller;

import com.audio.electric.domain.OperationLog;
import com.audio.electric.service.IOperationLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/12 0012 15:05
 */
@Controller
@RequestMapping("/log")
public class OperationLogController {
    @Autowired
    private IOperationLogService operationLogService;

    @RequestMapping("/listLog")
    public String listLog(OperationLog operationLog, Model model){
        List<OperationLog> operationLogList = operationLogService.listLog(operationLog);
        PageInfo pagehelper = new PageInfo(operationLogList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("operationLogList",operationLogList);
        return "system/log/log_list";
    }
}
