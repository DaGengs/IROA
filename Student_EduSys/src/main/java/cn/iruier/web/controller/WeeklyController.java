package cn.iruier.web.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.PageBean;
import cn.iruier.entity.Student;
import cn.iruier.entity.Weekly;
import cn.iruier.service.WeeklyService;

@Controller
public class WeeklyController {

    @Autowired
    private WeeklyService service;

    @RequestMapping(value = "/saveWeekly.do", method = {RequestMethod.POST})
    @ResponseBody
    public void saveWeekly(Weekly weekly, String stu_name, HttpServletResponse resp) throws IOException {
        if (service.save(weekly)) {
            resp.getWriter().println(1);
        } else {
            resp.getWriter().println(0);
        }
    }

    @RequestMapping("/getWeekly.do")
    @ResponseBody
    public PageBean queryWeekly(String stu_name) {
        PageBean<Weekly> pageBean = service.queryByName(stu_name);
        if (pageBean != null) {
            return pageBean;
        } else {
            return null;
        }
    }
}
