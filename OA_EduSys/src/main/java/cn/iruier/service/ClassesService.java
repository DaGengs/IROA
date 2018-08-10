package cn.iruier.service;

import java.util.List;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Classes;

public interface ClassesService {
    ResultVo save(Classes classes);

    ResultVo update(Classes classes);

    ResultVo delete(String no);

    int queryCount();

    PageVo<Classes> queryByPage(int page, int size);

    List<Classes> queryAll();

    String queryNoBysubId(int subj_id);
}
