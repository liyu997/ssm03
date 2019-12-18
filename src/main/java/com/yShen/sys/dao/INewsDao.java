package com.yShen.sys.dao;

import com.yShen.sys.model.News;
import com.yShen.sys.vo.NewsVo;

import java.util.List;

public interface INewsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    /**
     * 查询
     */
    List<News> queryAllNews(News news);
    List<News> queryAllNews_one(NewsVo news);

}
