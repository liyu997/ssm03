package com.yShen.sys.service;

import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.LogInfoVo;

public interface ILogInfoService {

    /**
     * 查询所有日志
     * @param logInfoVo
     * @return
     */
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo);
    /**
     * 添加日志
     * @param logInfoVo
     */
    public void addLogInfo(LogInfoVo logInfoVo);
    /**
     * 根据id删除日志
     * @param logInfoid
     */
    public void deleteLogInfo(Integer logInfoid);
    /**
     * 批量删除日志
     *
     */
    public void deleteBatchLogInfo(Integer [] ids);


}
