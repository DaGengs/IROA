package cn.iruier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iruier.entity.Employee;

public interface EmployeeMapper {
    @Insert("insert into t_employee(empl_no,empl_name,empl_phone,empl_gender,empl_email,empl_imgUrl,dept_id,createDate,status) values(#{empl_no},#{empl_name},#{empl_phone},#{empl_gender},#{empl_email},#{empl_imgUrl},#{dept_id},#{createDate},1)")
    int save(Employee employee);

    int update(Employee employee);

    @Update("update t_employee set status = 2 where empl_no = #{empl_no}")
    int delete(String empl_no);

    @Select("select count(1) from t_employee where status = 1")
    @ResultType(Integer.class)
    int queryCount();

    @Select("select e.*,d.dept_name from t_department d left join t_employee e on d.dept_id = e.dept_id where e.status = 1 limit #{index}, #{size}")
    @ResultMap("queryByPage")
    List<Employee> queryByPage(@Param("index") int index, @Param("size") int size);

    @Select("select e.*,d.dept_name from t_user u left join t_employee e on u.user_no=e.empl_no left join t_department d on e.dept_id = d.dept_id where e.status = 1 and e.empl_no = #{empl_no}")
    @ResultMap("queryByNo")
    Employee queryByno(String empl_no);

    @Select("select empl_no from t_employee order by empl_no desc limit 1")
    @ResultType(String.class)
    String queryNo();
}
