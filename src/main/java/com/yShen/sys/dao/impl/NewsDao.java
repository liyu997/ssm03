package com.yShen.sys.dao.impl;

import com.yShen.sys.dao.INewsDao;
import com.yShen.sys.model.News;
import com.yShen.sys.vo.NewsVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class NewsDao extends SqlSessionDaoSupport implements INewsDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getSqlSession().delete("News.deleteByPrimaryKey",id);
    }

    @Override
    public int insert(News record) {
        return getSqlSession().insert("News.insert",record);
    }

    @Override
    public int insertSelective(News record) {
        return getSqlSession().insert("News.insertSelective",record);
    }

    @Override
    public News selectByPrimaryKey(Integer id) {
        return getSqlSession().selectOne("News.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(News record) {
        return getSqlSession().update("News.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(News record) {
        return getSqlSession().update("News.updateByPrimaryKey",record);
    }

    @Override
    public List<News> queryAllNews(News news) {
        return getSqlSession().selectList("News.queryAllNews",news);
    }

    @Override
    public List<News> queryAllNews_one(NewsVo news) {
        news.setPage(news.getLimit()*(news.getPage()-1));
        return getSqlSession().selectList("News.queryAllNews_one",news);
    }
}
