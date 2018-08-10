package cn.iruier.web.controller;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Student;
import cn.iruier.service.StudentService;
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

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/importStu.do")
    @ResponseBody
    public ResultVo importStu(String class_no, MultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {
        String fileName = file.getOriginalFilename();
        HSSFWorkbook wrokBook = new HSSFWorkbook(file.getInputStream());
        HSSFSheet sheet = wrokBook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            int num = 0;
            num = num + i;
            HSSFRow row = sheet.getRow(i);
            Student student = new Student();
            student.setStu_idNumber(row.getCell(0).toString());
            student.setStu_name(row.getCell(1).toString());
            student.setStu_gender(row.getCell(2).toString());
            student.setStu_phone(new Double(row.getCell(3).getNumericCellValue()).longValue() + "");
            student.setStu_QQ(new Double(row.getCell(4).getNumericCellValue()).intValue() + "");
            student.setClass_no(class_no);
            student.setStu_introno(row.getCell(6).toString());
            student.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(row.getCell(7).getDateCellValue()));
            if (!service.save(student)) {
                return ResultVo.setERROR("导入失败！请检查数据！");
            }
        }
        return ResultVo.setOK("导入完成");
    }

    @RequestMapping(value = "studentAdd.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo studentAdd(@RequestBody Student student) {
        if (service.save(student)) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @RequestMapping("/queryByPage.do")
    @ResponseBody
    public PageVo<Student> queryByPage(int page, int limit) {
        return service.queryAll(page, limit);
    }

    @RequestMapping(value = "/delete.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete(String stu_no) {
        return service.delete(stu_no);
    }
}
