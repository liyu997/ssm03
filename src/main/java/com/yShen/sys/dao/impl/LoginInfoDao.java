package com.yShen.sys.dao.impl;

import com.yShen.sys.dao.ILogInfoDao;
import com.yShen.sys.model.LogInfo;
import com.yShen.sys.vo.LogInfoVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class LoginInfoDao extends SqlSessionDaoSupport implements ILogInfoDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getSqlSession().delete("LogInfo.deleteByPrimaryKey",id);
    }

    @Override
    public int insert(LogInfo record) {
        return getSqlSession().insert("LogInfo.insert",record);
    }

    @Override
    public int insertSelective(LogInfoVo record) {
        return getSqlSession().insert("LogInfo.insertSelective",record);
    }

    @Override
    public LogInfo selectByPrimaryKey(Integer id) {
        return getSqlSession().selectOne("LogInfo.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(LogInfo record) {
        return getSqlSession().update("LogInfo.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(LogInfo record) {
        return getSqlSession().update("LogInfo.updateByPrimaryKey",record);
    }

    @Override
    public List<LogInfo> queryAllLogInfo(LogInfo logInfo) {
        return getSqlSession().selectList("LogInfo.queryAllLogInfo",logInfo);
    }

    @Override
    public List<LogInfo> queryAllLogInfo_one(LogInfoVo logInfoVo) {
        logInfoVo.setPage(logInfoVo.getLimit()*(logInfoVo.getPage()-1));
        return getSqlSession().selectList("LogInfo.queryAllLogInfo_one",logInfoVo);
    }
}
