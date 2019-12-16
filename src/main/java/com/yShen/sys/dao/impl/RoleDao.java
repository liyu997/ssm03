package com.yShen.sys.dao.impl;

import com.yShen.sys.dao.IRoleDao;
import com.yShen.sys.model.Role;
import com.yShen.sys.vo.RoleVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class RoleDao extends SqlSessionDaoSupport implements IRoleDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return getSqlSession().delete("Role.deleteByPrimaryKey",roleid);
    }

    @Override
    public int insert(Role record) {
        return getSqlSession().insert("Role.insert",record);
    }

    @Override
    public int insertSelective(Role record) {
        return getSqlSession().insert("Role.insertSelective",record);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleid) {
        return getSqlSession().selectOne("Role.selectByPrimaryKey",roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return getSqlSession().update("Role.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return getSqlSession().update("Role.updateByPrimaryKey",record);
    }

    @Override
    public List<Role> queryAllRole(Role role) {
        return getSqlSession().selectList("Role.queryAllRole",role);
    }

    @Override
    public void deleteRolMenuByRid(Integer roleid) {
        getSqlSession().delete("Role.deleteRolMenuByRid", roleid);

    }

    @Override
    public void deleteRoleUserByRid(Integer roleid) {
        getSqlSession().delete("Role.deleteRoleUserByRid",roleid);

    }

    @Override
    public void insertRoleMenu(Integer rid, Integer mid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("rid",rid);
        map.put("mid",mid);
        getSqlSession().insert("Role.insertRoleMenu",map);
    }

    @Override
    public void deleteRoleUserByUid(Integer userid) {
        getSqlSession().delete("Role.deleteRoleUserByUid",userid);

    }

    @Override
    public List<Role> queryRoleByUid(Integer available, Integer userid) {


        Map<String,Integer> map = new HashMap<>();
        map.put("available",available);
        map.put("uid",userid);
        return getSqlSession().selectList("Role.queryRoleByUid",map);
    }

    @Override
    public List<Role> queryAllRole_one(RoleVo roleVo) {
        roleVo.setPage(roleVo.getLimit()*(roleVo.getPage()-1));
        return getSqlSession().selectList("Role.queryAllRole_one",roleVo);
    }
}
