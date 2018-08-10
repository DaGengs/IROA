package cn.iruier.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.AddressVo;
import cn.iruier.service.AddressService;

@Controller
public class AddressController {

    @Autowired
    private AddressService service;

    @RequestMapping("/getProvince.do")
    @ResponseBody
    public List<AddressVo> getProvince() {
        return service.queryProvince();
    }

    @RequestMapping("/getCity.do")
    @ResponseBody
    public List<AddressVo> getCity(String pno) {
        return service.queryCity(pno);
    }

    @RequestMapping("/getCounty.do")
    @ResponseBody
    public List<AddressVo> getCounty(String cno) {
        return service.queryCounty(cno);
    }
}
