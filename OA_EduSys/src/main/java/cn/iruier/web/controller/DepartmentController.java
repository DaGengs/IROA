package cn.iruier.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Classes;
import cn.iruier.entity.Department;
import cn.iruier.service.DepartmentService;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @RequestMapping(value = "/departmentAdd.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesAdd(@RequestBody Department department) {
        return service.save(department);
    }

    @RequestMapping(value = "/departmentUpdate.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesUpdate(String dept_name, int dept_id) {
        return service.update(dept_name, dept_id);
    }

    @RequestMapping(value = "/departmentDelete.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesDelete(int dept_id) {
        return service.delete(dept_id);
    }

    @RequestMapping("/departmentQuery.do")
    @ResponseBody
    public PageVo<Department> classesQuery(int page, int limit) {
        return service.queryByPage(page, limit);
    }

    @RequestMapping("/getDepartment.do")
    @ResponseBody
    public List<Department> getDepartment() {
        return service.queryAll();
    }
}
