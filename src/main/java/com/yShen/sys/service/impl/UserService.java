package com.yShen.sys.service.impl;

import com.yShen.sys.constast.SysConstast;
import com.yShen.sys.dao.IRoleDao;
import com.yShen.sys.dao.IUserDao;
import com.yShen.sys.model.Role;
import com.yShen.sys.model.User;
import com.yShen.sys.service.IUserService;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.SystemPropertyUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserService implements IUserService {

    IUserDao userDao;
    public IUserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }


    IRoleDao roleDao;

    public IRoleDao getRoleDao() {
        return roleDao;
    }
    @Autowired
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public User login(UserVo userVo) {
        userVo.setPwd(DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes()));
        return userDao.login(userVo);
    }

    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        return null;
    }

    @Override
    public DataGridView queryAllUser_one(UserVo userVo) {
        double size =  userDao.queryAllUser(userVo).size();
        int pagess = (int) Math.ceil(size/userVo.getLimit());
        if (pagess < userVo.getPage()) {
            userVo.setPage(pagess);
        }
        List<User> users = userDao.queryAllUser_one(userVo);
        return new DataGridView((long) size, users);
    }

    @Override
    public void addUser(UserVo userVo) {

        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
        userVo.setType(SysConstast.USER_TYPE_NORMAL);
        userDao.insertSelective(userVo);

    }

    @Override
    public void updateUser(UserVo userVo) {

        userDao.updateByPrimaryKeySelective(userVo);

    }

    @Override
    public void deleteUser(Integer userid) {
        userDao.deleteByPrimaryKey(userid);
        roleDao.deleteRoleUserByUid(userid);

    }

    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer id : ids) {
            deleteUser(id);
        }
    }

    @Override
    public void resetUserPwd(Integer userid) {
        User user = new User();
        user.setUserid(userid);
        user.setPwd((DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes())));
        userDao.updateByPrimaryKeySelective(user);

    }

    @Override
    public DataGridView queryUserRole(Integer userid) {
        //1,查询所有可用的角色
        Role role=new Role();
        role.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Role> allRole=this.roleDao.queryAllRole(role);
        //2,根据用户ID查询已拥有的角色
        List<Role> userRole=this.roleDao.queryRoleByUid(SysConstast.AVAILABLE_TRUE,userid);
        List<Map<String,Object>> data=new ArrayList<>();
        for (Role r1 : allRole) {
            Boolean LAY_CHECKED=false;
            for (Role r2 : userRole) {
                if(r1.getRoleid().equals(r2.getRoleid())) {
                    LAY_CHECKED=true;
                }
            }
            Map<String, Object> map=new HashMap<String, Object>();

            map.put("roleid", r1.getRoleid());
            map.put("rolename", r1.getRolename());
            map.put("roledesc", r1.getRoledesc());
            map.put("LAY_CHECKED", LAY_CHECKED);
            data.add(map);
        }
        return new DataGridView(data);
    }

    @Override
    public void saveUserRole(UserVo userVo) {
        Integer userid = userVo.getUserid();
        Integer[] roleIds = userVo.getIds();
        //根据用户id删除sys_role_user里面的数据
        this.roleDao.deleteRoleUserByUid(userid);
        //保存关系
        if(roleIds!=null&& roleIds.length>0) {
            for (Integer rid : roleIds) {
//                System.out.println(userid+"---"+rid);
                this.userDao.insertUserRole(userid,rid);
            }
        }
    }
}
