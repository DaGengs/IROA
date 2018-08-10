package cn.iruier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import cn.iruier.entity.LoginLog;

public interface LoginLogMapper {

    @Insert("insert into t_loginlog(ip,location,empl_no,createtime) values(#{ip},#{location},#{empl_no},now())")
    int save(LoginLog loginlog);

    @Select("select * from t_loginlog where empl_no = #{empl_no} order by createtime desc limit 0,10")
    @ResultType(LoginLog.class)
    List<LoginLog> queryByNo(String empl_no);
}
