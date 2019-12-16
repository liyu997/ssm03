package com.yShen.sys.service;

import com.yShen.sys.model.Menu;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.MenuVo;

import java.util.List;

public interface IMenuService {
    void insert(Menu menu);


    /**
     * 查询所有菜单
     */

    List<Menu> queryAllMenu(MenuVo menuVo);


    /**
     * 根据用户id查询用户的可用菜单
     */
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
//    public DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 添加菜单
     *
     * @param menuVo
     */
    public void addMenu(MenuVo menuVo);

    /**
     * 修改菜单
     *
     * @param menuVo
     */
    public void updateMenu(MenuVo menuVo);

    /**
     * 根据pid查询菜单数量
     *
     * @param pid
     * @return
     */
    public Integer queryMenuByPid(Integer pid);

    /**
     * 根据id删除菜单
     *
     * @param menuVo
     */
    public void deleteMenu(MenuVo menuVo);


    /**
     * 查询所有菜单
     */

    DataGridView queryAllMenu_one(MenuVo menuVo);
}
