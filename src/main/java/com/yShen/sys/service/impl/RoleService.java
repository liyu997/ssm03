package com.yShen.sys.service.impl;

import com.yShen.sys.constast.SysConstast;
import com.yShen.sys.dao.IMenuDao;
import com.yShen.sys.dao.IRoleDao;
import com.yShen.sys.model.Menu;
import com.yShen.sys.model.Role;
import com.yShen.sys.service.IRoleService;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.util.TreeNode;
import com.yShen.sys.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoleService implements IRoleService {

    IRoleDao roleDao;

    public IRoleDao getRoleDao() {
        return roleDao;
    }

    @Autowired
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    IMenuDao menuDao;

    public IMenuDao getMenuDao() {
        return menuDao;
    }
    @Autowired
    public void setMenuDao(IMenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public List<Role> queryAllRoleForList(RoleVo roleVo) {
        return roleDao.queryAllRole(roleVo);
    }

    @Override
    public List<Role> queryRoleByUserIdForList(RoleVo roleVo, Integer userId) {
        return roleDao.queryAllRole(roleVo);
    }

    @Override
    public DataGridView queryAllRole_one(RoleVo roleVo) {
        double size =  roleDao.queryAllRole(roleVo).size();
        int pagess = (int) Math.ceil(size/roleVo.getLimit());
        if (pagess < roleVo.getPage()) {
            roleVo.setPage(pagess);
        }
        List<Role> roles = roleDao.queryAllRole_one(roleVo);
        DataGridView dataGridView = new DataGridView((long) roleDao.queryAllRole(roleVo).size(), roles);
        return dataGridView;

    }

    @Override
    public void addRole(RoleVo roleVo) {
        roleDao.insertSelective(roleVo);
    }

    @Override
    public void updateRole(RoleVo roleVo) {
        roleDao.updateByPrimaryKeySelective(roleVo);
    }

    @Override
    public void deleteRole(Integer roleid) {

        roleDao.deleteByPrimaryKey(roleid);
        roleDao.deleteRoleUserByRid(roleid);
        roleDao.deleteRolMenuByRid(roleid);

        // 删除角色表的数据
        // 根据角色id删除sys_role_meun里面的数据
        // 根据角色id删除sys_role_user里面的数据


    }

    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer id : ids) {
            deleteRole(id);
        }

    }

    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        // 查询所有的可用的菜单
        Menu menu = new Menu();
        menu.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Menu> allMenu = menuDao.queryAllMenu(menu);
        // 根据角色ID查询当前角色拥有的菜单
        List<Menu> roleMenu = menuDao.queryMenuByRoleId(SysConstast.AVAILABLE_TRUE, roleid);

        List<TreeNode> data = new ArrayList<>();
        for (Menu m1 : allMenu) {
            String checkArr = SysConstast.CODE_ZERO+"";
            for (Menu m2 : roleMenu) {
                if (m1.getId().equals(m2.getId())) {
                    checkArr = SysConstast.CODE_ONE+"";
                    break;
                }
            }
            Integer id = m1.getId();
            Integer pid = m1.getPid();
            String title = m1.getTitle();
            Boolean spread = m1.getSpread().equals(SysConstast.SPREAD_TRUE) ? true : false;
            data.add(new TreeNode(id, pid, title, spread, checkArr));
        }
        return new DataGridView(data);
    }

    @Override
    public void saveRoleMenu(RoleVo roleVo) {
        Integer rid=roleVo.getRoleid();
        Integer [] mids=roleVo.getIds();
        //根据rid删除sys_role_menu里面所有数据
        this.roleDao.deleteRolMenuByRid(rid);
        //保存角色和菜单的关系
        for (Integer mid : mids) {
            this.roleDao.insertRoleMenu(rid,mid);
        }
    }
}
