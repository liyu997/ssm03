package com.yShen.sys.service.impl;

import com.yShen.sys.dao.INewsDao;
import com.yShen.sys.model.LogInfo;
import com.yShen.sys.model.News;
import com.yShen.sys.service.INewsService;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {

    private INewsDao newsDao;

    public INewsDao getNewsDao() {
        return newsDao;
    }

    @Autowired
    public void setNewsDao(INewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public DataGridView queryAllNews(NewsVo newsVo) {
        return  null;

    }

    @Override
    public DataGridView queryAllNews_one(NewsVo newsVo) {

        double size =  newsDao.queryAllNews(newsVo).size();
        int pagess = (int) Math.ceil(size/newsVo.getLimit());
        if (pagess < newsVo.getPage()) {
            newsVo.setPage(pagess);
        }
        List<News> data = this.newsDao.queryAllNews_one(newsVo);
        DataGridView dataGridView = new DataGridView((long) size, data);
        return dataGridView;
    }

    @Override
    public void addNews(NewsVo newsVo) {
        newsDao.insertSelective(newsVo);

    }

    @Override
    public void updateNews(NewsVo newsVo) {
        newsDao.updateByPrimaryKeySelective(newsVo);
    }

    @Override
    public void deleteNews(Integer newsid) {
        newsDao.deleteByPrimaryKey(newsid);

    }

    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer id : ids) {
            deleteNews(id);
        }
    }

    @Override
    public News queryNewsById(Integer id) {
        return newsDao.selectByPrimaryKey(id);
    }
}
