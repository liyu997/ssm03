package com.yShen.sys.dao;

import com.yShen.sys.model.LogInfo;
import com.yShen.sys.model.User;
import com.yShen.sys.vo.LogInfoVo;
import com.yShen.sys.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 查询用户
     */
    List<User> queryAllUser(UserVo userVo);

    List<User> queryAllUser_one(UserVo userVo);
    /**
     * 保存用户和角色的关系
     * @param userid
     * @param rid
     */
    void insertUserRole(@Param("uid")Integer userid, @Param("rid")Integer rid) ;
    /**
     登录方法
    */
    User login(User user);

}
