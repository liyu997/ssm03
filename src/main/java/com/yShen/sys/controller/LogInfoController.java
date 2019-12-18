package com.yShen.sys.controller;


import com.yShen.sys.service.ILogInfoService;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.util.ResultObj;
import com.yShen.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("logInfo")
public class LogInfoController {


    ILogInfoService logInfoService;

    public ILogInfoService getLogInfoService() {
        return logInfoService;
    }
    @Autowired
    public void setLogInfoService(ILogInfoService logInfoService) {
        this.logInfoService = logInfoService;
    }

    /**
     * 加载日志列表返回DataGridView
     */
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(LogInfoVo logInfoVo) {
        return this.logInfoService.queryAllLogInfo(logInfoVo);
    }

    /**
     * 删除日志
     */
    @RequestMapping("deleteLogInfo")
    public ResultObj deleteLogInfo(LogInfoVo logInfoVo) {
        try {
            this.logInfoService.deleteLogInfo(logInfoVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除日志
     */
    @RequestMapping("deleteBatchLogInfo")
    public ResultObj deleteBatchLogInfo(LogInfoVo logInfoVo) {
        try {
            this.logInfoService.deleteBatchLogInfo(logInfoVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}
