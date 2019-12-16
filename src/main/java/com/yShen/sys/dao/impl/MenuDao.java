package com.yShen.sys.dao.impl;

import com.yShen.sys.dao.IMenuDao;
import com.yShen.sys.model.Menu;
import com.yShen.sys.vo.MenuVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.menu;

@Repository
public class MenuDao extends SqlSessionDaoSupport implements IMenuDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getSqlSession().delete("Menu.deleteByPrimaryKey",id);
    }

    @Override
    public int insert(Menu record) {
        return getSqlSession().insert("Menu.insert" ,record);
    }

    @Override
    public int insertSelective(Menu record) {

        int insert = getSqlSession().insert("Menu.insertSelective", record);

        return insert;
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return getSqlSession().update("Menu.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }

    @Override
    public List<Menu> queryAllMenu(Menu menu) {
        return getSqlSession().selectList("Menu.queryAllMenu",menu);
    }


    @Override
    public List<Menu> queryAllMenu_one(MenuVo menuVo) {
        menuVo.setPage(menuVo.getLimit()*(menuVo.getPage()-1));
        return getSqlSession().selectList("Menu.queryAllMenu_one", menuVo);
    }

    @Override
    public Integer queryMenuByPid(Integer pid) {
        return getSqlSession().selectOne("Menu.queryMenuByPid",pid);
    }

    @Override
    public void deleteRoleMenuByMid(Integer mid) {

    }

    @Override
    public List<Menu> queryMenuByRoleId(Integer available, Integer rid) {
        List<Menu> list = new ArrayList<>();
        Map map = new HashMap();
        map.put("available",available);
        map.put("rid",rid);
        list = getSqlSession().selectList("Menu.queryMenuByRoleId",map);
        return list;
    }

    @Override
    public List<Menu> queryMenuByUid(Integer available, Integer userId) {
        List<Menu> list = new ArrayList<>();
        Map map = new HashMap();
        map.put("available",available);
        map.put("uid",userId);
        return getSqlSession().selectList("Menu.queryMenuByUid",map);
    }
}
