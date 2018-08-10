package cn.iruier.service.impl;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.RoleMapper;
import cn.iruier.entity.Role;
import cn.iruier.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public ResultVo save(String user_name) {
        if (mapper.save(user_name) > 0) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public ResultVo deleteRole(int role_id) {
        if (mapper.deleteRole(role_id) > 0) {
            return ResultVo.setOK("删除成功");
        } else {
            return ResultVo.setERROR("删除失败");
        }
    }

    @Override
    public PageVo<Role> queryByPage(int page, int size) {
        PageVo<Role> pageVo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * size;
        }
        List<Role> roles = mapper.queryRoles();
        if (roles != null) {
            pageVo.setCode(0);
            pageVo.setCount(mapper.queryCount());
            pageVo.setMsg("");
            pageVo.setData(roles);
        } else {
            pageVo.setCode(1);
            pageVo.setCount(0);
            pageVo.setMsg("暂无数据");
            pageVo.setData(new ArrayList<>());
        }
        return pageVo;
    }

    @Override
    public List<Role> queryRoles() {

        List<Role> roles = mapper.queryRoles();
        if (roles != null) {
            return roles;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Role> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public ResultVo updateMenu(int role_id, int[] menu_ids) {
        if (mapper.deleteMenu(role_id) >= 0) {
            try {
                for (int i = 0; i < menu_ids.length; i++) {
                    mapper.updateMenu(role_id, menu_ids[i]);
                }
                return ResultVo.setOK("更新权限成功");
            } catch (Exception e) {
                return ResultVo.setERROR("更新权限失败");
            }
        }
        return ResultVo.setERROR("更新权限失败");
    }
}
