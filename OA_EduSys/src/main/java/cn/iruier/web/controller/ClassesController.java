package cn.iruier.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Classes;
import cn.iruier.service.ClassesService;

@Controller
public class ClassesController {

    @Autowired
    private ClassesService service;

    @RequestMapping(value = "/classesAdd.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesAdd(@RequestBody Classes classes) {
        return service.save(classes);
    }

    @RequestMapping(value = "/classesUpdate.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesUpdate(@RequestBody Classes classes) {
        return service.update(classes);
    }

    @RequestMapping(value = "/classesDelete.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesDelete(String no) {
        return service.delete(no);
    }

    @RequestMapping("/classesQuery.do")
    @ResponseBody
    public PageVo<Classes> classesQuery(int page, int limit) {
        return service.queryByPage(page, limit);
    }

    @RequestMapping("/getClasses.do")
    @ResponseBody
    public List<Classes> getClasses() {
        return service.queryAll();
    }
}
