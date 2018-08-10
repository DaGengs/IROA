package cn.iruier.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Employee;
import cn.iruier.entity.User;
import cn.iruier.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/employeeAdd.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesAdd(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @RequestMapping(value = "/employeeUpdate.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesUpdate(@RequestBody Employee employee) {
        return service.update(employee);
    }

    @RequestMapping(value = "/employeeDelete.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo classesDelete(String empl_no) {
        return service.delete(empl_no);
    }

    @RequestMapping("/employeeQuery.do")
    @ResponseBody
    public PageVo<Employee> classesQuery(int page, int limit) {
        return service.queryByPage(page, limit);
    }

    @RequestMapping("/getEmplInfo.do")
    @ResponseBody
    public Employee getEmplInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return service.queryByNo(user.getUser_no());
    }

    @RequestMapping("/importEmpl.do")
    @ResponseBody
    public ResultVo importEmpl(int dept_id, MultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {
        System.out.println(dept_id);
        String fileName = file.getOriginalFilename();
        HSSFWorkbook wrokBook = new HSSFWorkbook(file.getInputStream());
        HSSFSheet sheet = wrokBook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            int num = 0;
            num = num + i;
            HSSFRow row = sheet.getRow(i);
            Employee employee = new Employee();
            employee.setEmpl_name(row.getCell(0).getStringCellValue());
            employee.setEmpl_phone(new Double(row.getCell(1).getNumericCellValue()).longValue() + "");
            employee.setEmpl_gender(row.getCell(2).getStringCellValue());
            employee.setEmpl_email(row.getCell(3).getStringCellValue());
            employee.setCreateDate(row.getCell(4).getDateCellValue());
            employee.setDept_id(dept_id);
            ResultVo resultVo = service.save(employee);
			/*if (resultVo.getCode() == 1) {
				return ResultVo.setERROR("导入失败！请检查数据！");
			}*/
        }

        return ResultVo.setOK("导入完成");
    }
}
