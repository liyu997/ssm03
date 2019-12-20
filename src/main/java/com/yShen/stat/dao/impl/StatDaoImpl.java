package com.yShen.stat.dao.impl;

import com.yShen.stat.dao.StatDao;
import com.yShen.stat.domain.BaseEntity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class StatDaoImpl extends SqlSessionDaoSupport implements StatDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<BaseEntity> queryCustomerAreaStat() {
        return getSqlSession().selectList("Base.queryCustomerAreaStat");
    }

    @Override
    public List<BaseEntity> queryOpernameYearGradeStat(String year) {
        return getSqlSession().selectList("Base.queryOpernameYearGradeStat",year);
    }

    @Override
    public List<Double> queryCompanyYearGradeStat(String year) {
        return getSqlSession().selectList("Base.queryCompanyYearGradeStat",year);
    }
}
