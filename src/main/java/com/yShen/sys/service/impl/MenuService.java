package com.yShen.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.bind.v2.TODO;
import com.yShen.sys.dao.IMenuDao;
import com.yShen.sys.model.Menu;
import com.yShen.sys.service.IMenuService;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuService implements IMenuService {
    IMenuDao menuDao;

    public IMenuDao getMenuDao() {
        return menuDao;
    }

    @Autowired
    public void setMenuDao(IMenuDao menuDao) {
        this.menuDao = menuDao;
    }


    @Override
    public void insert(Menu menu) {
        menuDao.insert(menu);
    }

    @Override
    public List<Menu> queryAllMenu(MenuVo menu) {
        return menuDao.queryAllMenu(menu);
    }

    /**
     * TODO 待做 权限列表
     */
    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
        return menuDao.queryMenuByUid(menuVo.getAvailable(),userId);
    }

    @Override
    public void addMenu(MenuVo menuVo) {
        menuDao.insertSelective(menuVo);


    }

    @Override
    public void updateMenu(MenuVo menuVo) {
        menuDao.updateByPrimaryKeySelective(menuVo);
    }

    @Override
    public Integer queryMenuByPid(Integer pid) {
        return menuDao.queryMenuByPid(pid);
    }

    @Override
    public void deleteMenu(MenuVo menuVo) {
        menuDao.deleteByPrimaryKey(menuVo.getId());
        menuDao.deleteRoleMenuByMid(menuVo.getId());

    }

    @Override
    public DataGridView queryAllMenu_one(MenuVo menuVo) {
        double size =  menuDao.queryAllMenu(menuVo).size();
        int pagess = (int) Math.ceil(size/menuVo.getLimit());
        if (pagess < menuVo.getPage()) {
            menuVo.setPage(pagess);
        }
        List<Menu> data = this.menuDao.queryAllMenu_one(menuVo);
        DataGridView dataGridView = new DataGridView((long) size, data);
        return dataGridView;
    }
}
