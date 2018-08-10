package cn.iruier.web.controller;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Menu;
import cn.iruier.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService service;

    @RequestMapping(value = "/saveMenu.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo saveMenu(@RequestBody Menu menu) {
        return service.save(menu);
    }

    @RequestMapping("/deleteMenu.do")
    @ResponseBody
    public ResultVo deleteMenu(int menu_id) {
        return service.deleteMenu(menu_id);
    }

    @RequestMapping(value = "/updateMenu.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo updateMenu(@RequestBody Menu menu) {
        return service.updateMenu(menu);
    }

    @RequestMapping("/menuQueryByPage.do")
    @ResponseBody
    public PageVo<Menu> menuQueryByPage(int page, int limit) {
        return service.queryByPage(page, limit);
    }

    @RequestMapping("/menuQueryAll.do")
    @ResponseBody
    public List<Menu> menuQueryAll() {
        return service.queryAll();
    }
}
