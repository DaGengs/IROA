package cn.iruier.dao;

import cn.iruier.entity.Student;

public interface StudentMapper {
    public int update(Student student);

    public Student queryByNo(String stu_no);
}
