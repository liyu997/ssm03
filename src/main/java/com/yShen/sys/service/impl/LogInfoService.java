package com.yShen.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yShen.sys.dao.ILogInfoDao;
import com.yShen.sys.model.LogInfo;
import com.yShen.sys.model.Menu;
import com.yShen.sys.service.ILogInfoService;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInfoService implements ILogInfoService {
    ILogInfoDao logInfoDao;

    public ILogInfoDao getLogInfoDao() {
        return logInfoDao;
    }
    @Autowired
    public void setLogInfoDao(ILogInfoDao logInfoDao) {
        this.logInfoDao = logInfoDao;
    }


    @Override
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo) {

        double size =  logInfoDao.queryAllLogInfo(logInfoVo).size();
        int pagess = (int) Math.ceil(size/logInfoVo.getLimit());
        if (pagess < logInfoVo.getPage()) {
            logInfoVo.setPage(pagess);
        }
        List<LogInfo> data = this.logInfoDao.queryAllLogInfo_one(logInfoVo);
        DataGridView dataGridView = new DataGridView((long) size, data);
        return dataGridView;
    }








    @Override
    public void addLogInfo(LogInfoVo logInfoVo) {

        logInfoDao.insertSelective(logInfoVo);

    }

    @Override
    public void deleteLogInfo(Integer logInfoid) {

        logInfoDao.deleteByPrimaryKey(logInfoid);

    }

    @Override
    public void deleteBatchLogInfo(Integer[] ids) {

        for (Integer id : ids) {
            deleteLogInfo(id);
        }

    }







 /*   @Override
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo) {
        Page<Object> page= PageHelper.startPage(logInfoVo.getPage(), logInfoVo.getLimit());
        List<LogInfo> data = this.logInfoMapper.queryAllLogInfo(logInfoVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addLogInfo(LogInfoVo logInfoVo) {
        this.logInfoMapper.insertSelective(logInfoVo);
    }

    @Override
    public void deleteLogInfo(Integer logInfoid) {
        this.logInfoMapper.deleteByPrimaryKey(logInfoid);
    }

    @Override
    public void deleteBatchLogInfo(Integer[] ids) {
        for (Integer integer : ids) {
            this.deleteLogInfo(integer);
        }
    }*/



}
