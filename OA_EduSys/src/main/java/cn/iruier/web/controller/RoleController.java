package cn.iruier.web.controller;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Role;
import cn.iruier.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService service;

    @RequestMapping(value = "/saveRole.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo saveRole(String role_name) {
        return service.save(role_name);
    }

    @RequestMapping(value = "/deleteRole.do")
    @ResponseBody
    public ResultVo deleteRole(int role_id) {
        return service.deleteRole(role_id);
    }

    @RequestMapping("/roleQueryByPage.do")
    @ResponseBody
    public PageVo<Role> roleQueryByPage(int page, int limit) {
        return service.queryByPage(page, limit);
    }

    @RequestMapping("/roleQueryAll.do")
    @ResponseBody
    public List<Role> roleQueryAll() {
        return service.queryAll();
    }

    @RequestMapping(value = "/updateMyMenu.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo updateMyMenu(int role_id, @RequestParam("menu_ids[]") int[] menu_ids) {
        return service.updateMenu(role_id, menu_ids);
    }
}
