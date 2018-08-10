package cn.iruier.service;

import cn.iruier.common.vo.EchartsVo;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ProcessVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Process;

public interface ProcessService {
    ResultVo insert(Process process, String rname);

    ResultVo update(String tid, int id, int status);

    ResultVo del(String pid, String name, int id);

    PageVo<Process> queryAll(String no);

    PageVo<ProcessVo> queryByName(String name);

    EchartsVo queryBtEcharts(String pid);
}
