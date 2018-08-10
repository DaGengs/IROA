package cn.iruier.web.controller;

import cn.iruier.common.vo.EchartsVo;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ProcessVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Process;
import cn.iruier.entity.User;
import cn.iruier.service.ProcessService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProcessController {

    @Autowired
    private ProcessService service;

    //新增
    @RequestMapping(value = "/processAdd.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo save(@RequestBody Process process, String rname) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        process.setApplyNo(user.getUser_no());
        process.setApplyName(user.getUser_name());
        return service.insert(process, rname);
    }

    //审批
    @RequestMapping("/processUpdate.do")
    @ResponseBody
    public ResultVo update(String tid, int id, int status) {
        return service.update(tid, id, status);
    }

    //我的流程记录
    @RequestMapping("/processQueryMy.do")
    @ResponseBody
    public PageVo<Process> processQueryMy() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return service.queryAll(user.getUser_no());
    }

    /*取消申请*/
    @RequestMapping("/processDelete.do")
    @ResponseBody
    public ResultVo processDelete(String pid, int id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return service.del(pid, user.getUser_name(), id);
    }

    //待办事项
    @RequestMapping("/processNoList.do")
    @ResponseBody
    public PageVo<ProcessVo> processNoList() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return service.queryByName(user.getUser_name());
    }

    /*进度查询*/
    @RequestMapping("/processECharts.do")
    @ResponseBody
    public EchartsVo processECharts(String pid) {
        return service.queryBtEcharts(pid);
    }
}
