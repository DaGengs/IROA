package cn.iruier.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.iruier.common.utils.MD5Utils;
import cn.iruier.common.vo.MenuVo;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.LoginLog;
import cn.iruier.service.LoginLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.iruier.entity.User;
import cn.iruier.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private LoginLogService logService;

    @RequestMapping(value = "/saveUser.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo saveUser(@RequestBody User user) {
        return service.save(user);
    }

    @RequestMapping(value = "/login.do", method = {RequestMethod.POST})
    public String login(String user_no, String user_password) throws IOException {
        User user = service.login(user_no, user_password);
        if (user != null) {
            logService.save(user_no);
            return "redirect:index.html";
        } else {
            return "redirect:login.html";
        }
    }

    @RequestMapping(value = "/getLoginlog.do")
    @ResponseBody
    public PageVo<LoginLog> getLoginlog(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return logService.queryByNo(user.getUser_no());
    }

    @RequestMapping("/loginout.do")
    public String logingOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect: login.html";
    }

    @RequestMapping("/getUser.do")
    @ResponseBody
    public User getUser(HttpSession session) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return user;
    }

    @RequestMapping(value = "/getPassword.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo getPassword(String password, HttpSession session) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (Objects.equals(MD5Utils.md5(password), user.getUser_password())) {
            return ResultVo.setOK("");
        } else {
            return ResultVo.setERROR("输入的旧密码不正确");
        }
    }

    @RequestMapping(value = "edidPassword.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo edidPassword(String new_password, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return service.updatePwd(new_password, user.getUser_no());
    }

    @RequestMapping(value = "/updateMyRole.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo updateMyRole(int user_id, @RequestParam("role_ids[]") int[] role_ids) {
        return service.updateRole(user_id, role_ids);
    }

    @RequestMapping("/getMenu.do")
    @ResponseBody
    public List<MenuVo> getMenu() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return service.queryMenu(user.getUser_id());
    }

    @RequestMapping("/userQueryByPage.do")
    @ResponseBody
    public PageVo<User> userqueryByPage(int page, int limit) {
        return service.queryByPage(page, limit);
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    public ResultVo deleteUser(int user_id) {
        return service.deleteUser(user_id);
    }
}
