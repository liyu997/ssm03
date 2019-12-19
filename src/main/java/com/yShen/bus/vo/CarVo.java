package com.yShen.bus.vo;


import com.yShen.bus.model.Car;

public class CarVo extends Car {

	/**
	 * 分页参数
	 */
	private Integer page;
	private Integer limit;

	// 接收多个id
	private String[] ids;

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
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

}
