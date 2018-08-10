package cn.iruier.service;

import java.util.List;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Subject;

public interface SubjectService {

    ResultVo save(Subject subject);

    ResultVo update(Subject subject);

    ResultVo delete(int subj_id);

    int queryCount();

    PageVo<Subject> queryByPage(int page, int size);

    List<Subject> queryAll();

    String queryNo();
}
