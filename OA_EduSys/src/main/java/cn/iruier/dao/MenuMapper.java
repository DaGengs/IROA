package cn.iruier.dao;

import cn.iruier.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    /*新增权限*/
    int save(Menu menu);

    /*删除权限*/
    int deleteMenu(int menu_id);

    /*修改权限*/
    int updateMenu(Menu menu);

    /*分页查询所有权限*/
    List<Menu> queryByPage(@Param("index") int index, @Param("size") int size);

    /*查询所有权限*/
    List<Menu> queryAll();

    /*查询数量*/
    int queryCount();
}
