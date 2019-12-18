package com.yShen.sys.dao;

import com.yShen.sys.model.LogInfo;
import com.yShen.sys.vo.LogInfoVo;

import java.util.List;

public interface ILogInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(LogInfo record);

    int insertSelective(LogInfoVo record);

    LogInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogInfo record);

    int updateByPrimaryKey(LogInfo record);

    /**
     * 查询日志
     */
    List<LogInfo> queryAllLogInfo(LogInfo logInfo);


    List<LogInfo> queryAllLogInfo_one(LogInfoVo logInfoVo);
}
