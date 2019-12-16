package com.yShen.sys.service;

import com.yShen.sys.model.User;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.UserVo;

public interface IUserService {
    User login(UserVo userVo);


    /**
     * 查询所有用户
     * @param userVo
     */
    public DataGridView queryAllUser(UserVo userVo);


    public DataGridView queryAllUser_one(UserVo userVo);

    /**
     * 添加用户
     * @param userVo
     */
    public void addUser(UserVo userVo);

    /**
     * 修改用户
     * @param userVo
     */
    public void updateUser(UserVo userVo);

    /**
     * 根据id删除用户
     * @param userid
     */
    public void deleteUser(Integer userid);
    /**
     * 批量删除用户
     */
    public void deleteBatchUser(Integer [] ids);

    /**
     * 重置密码
     * @param userid
     */
    public void resetUserPwd(Integer userid);

    /**
     *  加载用户管理的分配角色的数据
     * @param userid
     */
    DataGridView queryUserRole(Integer userid);

    /**
     * 保存用户和角色的关系
     * @param userVo
     */
    void saveUserRole(UserVo userVo);
}
