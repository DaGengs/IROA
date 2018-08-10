package cn.iruier.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.PageBean;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Exam;
import cn.iruier.service.ExamService;

@Controller
public class ExamController {

    @Autowired
    private ExamService service;

    @RequestMapping("/examAdd.do")
    @ResponseBody
    public ResultVo examAdd(Exam exam) {
        System.out.println(exam);
        return service.save(exam);
    }

    @RequestMapping("/examQuery.do")
    @ResponseBody
    public PageBean<Exam> examQuery() {
        return service.queryAll();
    }

}
