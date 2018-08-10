package cn.iruier.web.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.PageBean;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Complaint;
import cn.iruier.entity.Question;
import cn.iruier.entity.Student;
import cn.iruier.entity.Weekly;
import cn.iruier.service.ComplaintService;
import cn.iruier.service.QuestionService;
import cn.iruier.service.WeeklyService;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    @RequestMapping(value = "/saveComplaint.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo saveComplaint(Complaint complaint) throws IOException {
        return service.save(complaint);
    }

}
