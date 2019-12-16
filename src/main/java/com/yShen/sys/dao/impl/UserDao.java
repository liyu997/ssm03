package com.yShen.sys.dao.impl;

import com.yShen.sys.dao.IUserDao;
import com.yShen.sys.model.User;
import com.yShen.sys.model.Menu;
import com.yShen.sys.model.User;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.UserVo;
import com.yShen.sys.vo.UserVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserDao extends SqlSessionDaoSupport implements IUserDao {


    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getSqlSession().delete("User.deleteByPrimaryKey",id);
    }

    @Override
    public int insert(User record) {
        return getSqlSession().insert("User.insert",record);
    }

    @Override
    public int insertSelective(User record) {
        return getSqlSession().insert("User.insertSelective",record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {

        return getSqlSession().selectOne("User.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return getSqlSession().update("User.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return getSqlSession().update("User.updateByPrimaryKey",record);
    }

    @Override
    public List<User> queryAllUser(UserVo userVo) {
        return getSqlSession().selectList("User.queryAllUser",userVo);
    }

    @Override
    public List<User> queryAllUser_one(UserVo userVo) {
        userVo.setPage(userVo.getLimit()*(userVo.getPage()-1));
        return getSqlSession().selectList("User.queryAllUser_one",userVo);
    }

    @Override
    public void insertUserRole(Integer userid, Integer rid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("rid",rid);
        map.put("uid",userid);
        getSqlSession().insert("User.insertUserRole",map);



    }


    @Override
    public User login(User user) {
        User user1 = getSqlSession().selectOne("User.login",user);
        return user1;
    }
}
