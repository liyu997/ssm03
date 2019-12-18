package com.yShen.sys.vo;

import java.util.Arrays;
import java.util.Date;

import com.yShen.sys.model.News;
import org.springframework.format.annotation.DateTimeFormat;


public class NewsVo extends News {
	/**
	 * 分页参数
	 */
	private Integer page;
	private Integer limit;
	
	/**
	 * 时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	
	//接收多个id
	private Integer [] ids;
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	@Override
	public String toString() {
		return "NewsVo{" +
				"page=" + page +
				", limit=" + limit +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", ids=" + Arrays.toString(ids) +
				'}';
	}
}
