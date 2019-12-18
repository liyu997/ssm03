package com.yShen.sys.controller;


import com.yShen.sys.model.News;
import com.yShen.sys.model.User;
import com.yShen.sys.service.INewsService;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.util.ResultObj;
import com.yShen.sys.util.WebUtils;
import com.yShen.sys.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("news")
public class NewsController {
    private INewsService newsService;

    public INewsService getNewsService() {
        return newsService;
    }
    @Autowired
    public void setNewsService(INewsService newsService) {
        this.newsService = newsService;
    }


    /**
     * 加载公告列表返回DataGridView
     */
    @RequestMapping("loadAllNews")
    public DataGridView loadAllNews(NewsVo newsVo) {
        System.out.println(newsVo);
        System.out.println("进入");
        return this.newsService.queryAllNews_one(newsVo);
    }

    /**
     * 添加公告
     */
    @RequestMapping("addNews")
    public ResultObj addNews(NewsVo newsVo) {
        try {
            newsVo.setCreatetime(new Date());
            User user=(User) WebUtils.getHttpSession().getAttribute("user");
            newsVo.setOpername(user.getRealname());
            this.newsService.addNews(newsVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    /**
     * 修改公告
     */
    @RequestMapping("updateNews")
    public ResultObj updateNews(NewsVo newsVo) {
        try {
            this.newsService.updateNews(newsVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 删除公告
     */
    @RequestMapping("deleteNews")
    public ResultObj deleteNews(NewsVo newsVo) {
        try {
            this.newsService.deleteNews(newsVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     */
    @RequestMapping("deleteBatchNews")
    public ResultObj deleteBatchNews(NewsVo newsVo) {
        try {
            this.newsService.deleteBatchNews(newsVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 根据id查询公告
     */
    @RequestMapping("loadNewsById")
    public News loadNewsById(Integer id) {
        return this.newsService.queryNewsById(id);
    }











}
