package cn.iruier.dao;

import cn.iruier.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /*新增角色*/
    int save(String role_name);

    /*删除角色*/
    int deleteRole(int role_id);

    /*分页查询所有*/
    List<Role> queryByPage(@Param("index") int index, @Param("size") int size);

    List<Role> queryRoles();

    /*查询所有*/
    List<Role> queryAll();

    /*查询数量*/
    int queryCount();

    /*删除对应权限*/
    int deleteMenu(int role_id);

    /*更新对应权限*/
    int updateMenu(@Param("role_id") int role_id, @Param("menu_id") int menu_id);
}
