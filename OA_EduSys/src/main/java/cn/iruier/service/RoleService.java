package cn.iruier.service;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Role;

import java.util.List;

public interface RoleService {
    /*新增角色*/
    ResultVo save(String role_name);

    /*删除角色*/
    ResultVo deleteRole(int role_id);

    /*分页查询所有*/
    PageVo<Role> queryByPage(int page, int size);

    List<Role> queryRoles();

    /*查询所有*/
    List<Role> queryAll();

    /*更新对应权限*/
    ResultVo updateMenu(int role_id, int[] menu_ids);
}
