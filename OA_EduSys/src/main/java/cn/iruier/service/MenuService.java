package cn.iruier.service;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Menu;

import java.util.List;

public interface MenuService {
    /*新增权限*/
    ResultVo save(Menu menu);

    /*删除权限*/
    ResultVo deleteMenu(int menu_id);

    /*修改权限*/
    ResultVo updateMenu(Menu menu);

    /*分页查询所有权限*/
    PageVo<Menu> queryByPage(int page, int size);

    /*查询所有权限*/
    List<Menu> queryAll();

}
