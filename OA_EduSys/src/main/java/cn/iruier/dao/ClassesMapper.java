package cn.iruier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iruier.entity.Classes;

public interface ClassesMapper {
    @Insert("insert into t_classes(class_no,class_name,subj_id,startTime,class_week,status) values(#{class_no},#{class_name},#{subj_id},#{startTime},#{class_week},1)")
    int save(Classes classes);

    @Update("update t_classes set class_name=#{class_name},subj_id=#{subj_id},startTime=#{startTime},class_week=#{class_week} where status = 1 and class_no = #{class_no}")
    int update(Classes classes);

    @Update("update t_classes set status = 2 where class_no = #{no}")
    int delete(String no);

    @Select("select count(*) from t_classes where status = 1")
    @ResultType(Integer.class)
    int queryCount();

    @Select("select c.*,s.subj_name,count(stu.class_no) count from t_classes c left join t_student stu on stu.class_no = c.class_no left join t_subject s on c.subj_id = s.subj_id where c.status = 1 group by c.class_no limit #{index}, #{size}")
    @ResultMap("queryByPage")
    List<Classes> queryByPage(@Param("index") int index, @Param("size") int size);

    @Select("select class_no,class_name from t_classes where status = 1")
    @ResultType(Classes.class)
    List<Classes> queryAll();

    @Select("select class_no from t_classes where subj_id = #{subj_id} order by class_no desc limit 1")
    @ResultType(String.class)
    String queryNoBysubId(int subj_id);
}
