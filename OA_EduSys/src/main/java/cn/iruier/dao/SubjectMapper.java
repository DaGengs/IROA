package cn.iruier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iruier.entity.Subject;

public interface SubjectMapper {
    @Insert("insert into t_subject(subj_id,subj_name,subj_week,subj_type,createtime,status) values(#{subj_id},#{subj_name},#{subj_week},#{subj_type},#{createtime},1)")
    int save(Subject subject);

    @Update("update t_subject set subj_name = #{subj_name},subj_week=#{subj_week},subj_type=#{subj_type} where status = 1 and subj_id = #{subj_id}")
    int update(Subject subject);

    @Update("update t_subject set status = 2 where status = 1 and subj_id = #{subj_id}")
    int delete(int subj_id);

    @Select("select count(*) from t_subject where status = 1")
    @ResultType(Integer.class)
    int queryCount();

    @Select("select * from t_subject where status = 1 limit #{index}, #{size}")
    @ResultType(Subject.class)
    List<Subject> queryByPage(@Param("index") int index, @Param("size") int size);

    @Select("select subj_id,subj_name from t_subject where status = 1")
    @ResultType(Subject.class)
    List<Subject> queryAll();

    @Select("select subj_id from t_subject order by subj_id desc limit 1")
    @ResultType(String.class)
    String queryNo();
}
