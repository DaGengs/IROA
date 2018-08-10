package cn.iruier.service;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Student;

public interface StudentService {
    boolean save(Student student);

    String queryNoByClsNo(String class_no);

    PageVo<Student> queryAll(int page, int size);

    ResultVo delete(String stu_no);
}
