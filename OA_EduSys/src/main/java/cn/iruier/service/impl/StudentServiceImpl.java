package cn.iruier.service.impl;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.dao.StudentMapper;
import cn.iruier.entity.Student;
import cn.iruier.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public boolean save(Student student) {
        String class_no = student.getClass_no();
        String stu_no = mapper.queryNoByClsNo(class_no);

        if (stu_no == null) {
            stu_no = "ZZ" + class_no + "01";
        } else {
            stu_no = "ZZ" + (Integer.parseInt(stu_no.substring(2)) + 1);
        }
        student.setStu_no(stu_no);
        return mapper.save(student) > 0;
    }

    @Override
    public String queryNoByClsNo(String class_no) {
        return mapper.queryNoByClsNo(class_no);
    }

    @Override
    public PageVo<Student> queryAll(int page, int size) {
        int index = 0;
        if (page > 0) {
            index = (page - 1) * size;
        }
        List<Student> students = mapper.queryAll(index, size);
        PageVo<Student> pageVo = new PageVo<>();
        if (students != null) {
            pageVo.setCode(0);
            pageVo.setMsg("");
            pageVo.setData(students);
            pageVo.setCount(mapper.queryCount());
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("暂无数据");
            pageVo.setData(new ArrayList<>());
            pageVo.setCount(0);
        }
        return pageVo;
    }

    @Override
    public ResultVo delete(String stu_no) {
        if (StringUtils.empty(stu_no)) {
            if (mapper.delete(stu_no) > 0) {
                return ResultVo.setOK("删除成功");
            } else {
                return ResultVo.setERROR("删除失败");
            }
        }
        return ResultVo.setERROR("删除失败");
    }
}
