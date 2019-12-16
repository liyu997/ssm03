package com.yShen.sys.vo;

import com.yShen.sys.model.Menu;

public class MenuVo extends Menu {


    private Integer spread;

    private Integer page;

    private Integer limit;


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


    @Override
    public Integer getSpread() {
        return spread;
    }

    @Override
    public void setSpread(Integer spread) {
        this.spread = spread;
    }


    @Override
    public String toString() {
        return "MenuVo{" +
                "spread=" + spread +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
