package cn.iruier.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.entity.User;
import cn.iruier.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/login.do", method = {RequestMethod.POST})
    public String login(String no, String password, HttpSession session) throws IOException {
        User user = service.login(no, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:index.html";
        } else {
            return "redirect:login.html";
        }
    }

    @RequestMapping("/loginout.do")
    public String logingOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login.html";
    }

    @RequestMapping("/getUser.do")
    @ResponseBody
    public User getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user;
    }
}
