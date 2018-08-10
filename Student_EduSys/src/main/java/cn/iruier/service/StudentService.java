package cn.iruier.service;

import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Student;

public interface StudentService {
    ResultVo update(Student student);

    public Student queryByNo(String no);
}
