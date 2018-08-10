package cn.iruier.dao;

import cn.iruier.common.vo.EchartsItem;
import cn.iruier.common.vo.ProcessVo;
import cn.iruier.entity.Process;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProcessMapper {
    //发起流程
    @Insert("insert into t_process (type,applyName,info,applyNo,startDate,endDate,days,pid,status) values(#{type},#{applyName},#{info},#{applyNo},#{startDate},#{endDate},#{days},#{pid},1)")
    int insert(Process process);

    //审批流程
    @Update("update t_process set status=#{status} where id=#{id}")
    int update(@Param("id") int id, @Param("status") int status);

    //查询流程信息
    @Select("select * from t_process where applyNo=#{no}")
    @ResultType(Process.class)
    List<Process> queryAll(String no);

    //待办事项
    @Select("select t.id_ tid,t.name_ tname,t.CREATE_TIME_ tctime,p.* from act_ru_task t left join t_process p on t.PROC_INST_ID_=p.pid where t.ASSIGNEE_=#{name}")
    @ResultType(ProcessVo.class)
    List<ProcessVo> queryByName(String name);

    @Select("select PROC_inst_id_ id,act_name_ aname,start_time_ stime,end_time_ etime,duration_ dura from act_hi_actinst where PROC_inst_id_=#{pid} order by start_time_")
    @ResultType(EchartsItem.class)
    public List<EchartsItem> queryBtEcharts(String pid);
}
