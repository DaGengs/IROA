package cn.iruier.dao;

import org.apache.ibatis.annotations.*;

import cn.iruier.entity.Student;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into t_student(stu_no,stu_idNumber,stu_name,stu_gender,stu_phone,stu_QQ,class_no,stu_introno,createtime,status) values(#{stu_no},#{stu_idNumber},#{stu_name},#{stu_gender},#{stu_phone},#{stu_QQ},#{class_no},#{stu_introno},#{createtime},1)")
    int save(Student student);

    @Select("select stu_no from t_student where class_no = #{class_no} order by stu_no desc limit 1")
    @ResultType(String.class)
    String queryNoByClsNo(String class_no);

    @Select("select s.*,c.class_name from t_student s left join t_classes c on s.class_no = c.class_no limit #{index}, #{size}")
    @ResultType(Student.class)
    List<Student> queryAll(@Param("index") int index, @Param("size") int size);

    @Select("select count(*) from t_student")
    @ResultType(Integer.class)
    int queryCount();

    @Update("update t_student set status = 2 where stu_no = #{stu_no}")
    int delete(String stu_no);
}
