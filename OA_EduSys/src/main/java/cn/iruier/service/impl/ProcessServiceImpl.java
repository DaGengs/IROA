package cn.iruier.service.impl;

import cn.iruier.common.vo.*;
import cn.iruier.dao.ProcessMapper;
import cn.iruier.entity.Process;
import cn.iruier.service.ProcessService;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper mapper;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private FormService formService;

    @Override
    public ResultVo insert(Process process, String rname) {
        Map<String, Object> map = new HashMap<>();
        map.put("applyName", process.getApplyName());
        map.put("replyName", rname);
        map.put("startDate", rname);
        map.put("endDate", rname);
        map.put("days", process.getDays());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process_Apply", map);
        process.setPid(processInstance.getId());
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        taskService.complete(task.getId(), map);
        if (mapper.insert(process) > 0) {
            return ResultVo.setOK("申请成功");
        } else {
            return ResultVo.setERROR("申请失败");
        }
    }

    @Override
    public ResultVo update(String tid, int id, int status) {
        taskService.complete(tid);
        if (mapper.update(id, status) > 0) {
            return ResultVo.setOK("审批成功");
        } else {
            return ResultVo.setERROR("审批失败");
        }
    }

    @Override
    public ResultVo del(String pid, String name, int id) {
        taskService.resolveTask(taskService.createTaskQuery().processInstanceId(pid).taskAssignee(name).singleResult().getId());
        if (mapper.update(id, 4) > 0) {
            return ResultVo.setOK("删除成功");
        } else {
            return ResultVo.setERROR("删除失败");
        }
    }

    @Override
    public PageVo<Process> queryAll(String no) {
        PageVo<Process> pageVo = new PageVo<>();
        List<Process> processes = mapper.queryAll(no);
        if (processes != null) {
            pageVo.setCode(0);
            pageVo.setMsg("");
            pageVo.setData(processes);
            pageVo.setCount(pageVo.getData().size());
        } else {
            pageVo.setCode(1);
            pageVo.setData(new ArrayList<>());
            pageVo.setCount(0);
            pageVo.setMsg("暂无数据");
        }
        return pageVo;
    }

    @Override
    public PageVo<ProcessVo> queryByName(String name) {
        PageVo<ProcessVo> pageVo = new PageVo<>();
        List<ProcessVo> processesVos = mapper.queryByName(name);
        if (processesVos != null) {
            pageVo.setCode(0);
            pageVo.setMsg("");
            pageVo.setData(processesVos);
            pageVo.setCount(pageVo.getData().size());
        } else {
            pageVo.setCode(1);
            pageVo.setData(new ArrayList<>());
            pageVo.setCount(0);
            pageVo.setMsg("暂无数据");
        }
        return pageVo;

    }

    @Override
    public EchartsVo queryBtEcharts(String pid) {
        List<EchartsItem> echartsItems = mapper.queryBtEcharts(pid);
        if (echartsItems != null) {
            EchartsVo vo = new EchartsVo();
            for (int i = 0; i < echartsItems.size(); i++) {
                EchartsItem item = echartsItems.get(i);
                if (i == 0) {
                    vo.setId(item.getId());
                }
                vo.getDatax().add(item.getAname());
                vo.getDatas1().add(item.getStime());
                vo.getDatas2().add(item.getEtime());
                vo.getDatas3().add(item.getDura());
            }
            return vo;
        }
        return null;
    }
}
