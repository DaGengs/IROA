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
import cn.iruier.entity.Subject;
import cn.iruier.service.DepartmentService;
import cn.iruier.service.SubjectService;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService service;

    @RequestMapping(value = "/subjectAdd.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesAdd(@RequestBody Subject subject) {
        return service.save(subject);
    }

    @RequestMapping(value = "/subjectUpdate.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesUpdate(@RequestBody Subject subject) {
        return service.update(subject);
    }

    @RequestMapping(value = "/subjectDelete.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesDelete(int subj_id) {
        return service.delete(subj_id);
    }

    @RequestMapping("/subjectQuery.do")
    @ResponseBody
    public PageVo<Subject> classesQuery(int page, int limit) {
        return service.queryByPage(page, limit);
    }

    @RequestMapping("/getSubject.do")
    @ResponseBody
    public List<Subject> getSubject() {
        return service.queryAll();
    }
}
