package cn.iruier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iruier.entity.Department;

public interface DepartmentMapper {

    @Insert("insert into t_department(dept_id,dept_name,dept_p_id,dept_level,createtime,status) values(#{dept_id},#{dept_name},#{dept_p_id},#{dept_level},#{createtime},1)")
    int save(Department department);

    @Update("update t_department set dept_name = #{dept_name} where status = 1 and dept_id = #{dept_id}")
    int update(@Param("dept_name") String dept_name, @Param("dept_id") int dept_id);

    @Update("update t_department set status = 2 where status = 1 and dept_id = #{dept_id}")
    int delete(int dept_id);

    @Select("select count(*) from t_department where status = 1")
    @ResultType(Integer.class)
    int queryCount();

    @Select("select * from t_department where status = 1 limit #{index}, #{size}")
    @ResultType(Department.class)
    List<Department> queryByPage(@Param("index") int index, @Param("size") int size);

    @Select("select dept_id,dept_name from t_department where status = 1")
    @ResultType(Department.class)
    List<Department> queryAll();

    @Select("select dept_id from t_department order by dept_id desc limit 1")
    @ResultType(String.class)
    String queryNo();
}
