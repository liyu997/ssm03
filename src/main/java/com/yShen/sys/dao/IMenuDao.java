package com.yShen.sys.dao;

import com.yShen.sys.model.Menu;
import com.yShen.sys.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMenuDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 查询所有菜单
     */
    List<Menu> queryAllMenu(Menu menu);


    List<Menu> queryAllMenu_one(MenuVo menuVo);

    /**
     * 根据pid查询菜单数量
     * @param pid
     * @return
     */
    Integer queryMenuByPid(@Param("pid")Integer pid);

    /**
     * 根据菜单id删除sys_role_menu里面的数据
     * @param mid
     */
    void deleteRoleMenuByMid(@Param("mid")Integer mid);

    /**
     * 根据角色ID查询菜单
     */
    List<Menu> queryMenuByRoleId(@Param("available")Integer available, @Param("rid")Integer rid);

    List<Menu> queryMenuByUid(Integer available, Integer userId);
}
