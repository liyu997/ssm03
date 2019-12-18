package com.yShen.sys.service;

import com.yShen.sys.model.News;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.NewsVo;

public interface INewsService {

    /**
     * 查询所有公告
     * @param newsVo
     * @return
     */
    public DataGridView queryAllNews(NewsVo newsVo);
    public DataGridView queryAllNews_one(NewsVo newsVo);
    /**
     * 添加公告
     * @param newsVo
     */
    public void addNews(NewsVo newsVo);
    /**
     * 修改公告
     * @param newsVo
     */
    public void updateNews(NewsVo newsVo);
    /**
     * 根据id删除公告
     * @param newsid
     */
    public void deleteNews(Integer newsid);
    /**
     * 批量删除公告
     */
    public void deleteBatchNews(Integer [] ids);

    /**
     * 查询一个公告
     * @param id
     * @return
     */
    public News queryNewsById(Integer id);
}
