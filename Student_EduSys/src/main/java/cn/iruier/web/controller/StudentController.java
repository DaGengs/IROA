package cn.iruier.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Address;
import cn.iruier.entity.Contact;
import cn.iruier.entity.Student;
import cn.iruier.entity.User;
import cn.iruier.service.AddressService;
import cn.iruier.service.ContactService;
import cn.iruier.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService stuService;
    @Autowired
    private ContactService conService;
    @Autowired
    private AddressService addService;

    @RequestMapping("/getStudent.do")
    @ResponseBody
    public Student getStudent(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Student student = stuService.queryByNo(user.getUser_no());
        if (student != null) {
            return student;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/updateInfo.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo saveInfo(@RequestBody Student student) {
        Address address = student.getAddress();
        Contact contact = student.getContact();
        if (conService.save(contact) && addService.save(address)) {
            return stuService.update(student);
        } else {
            return ResultVo.setERROR("保存失败");
        }
    }
}
