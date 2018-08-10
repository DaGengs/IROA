package cn.iruier.service;

import java.util.List;

import cn.iruier.common.vo.PageBean;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Exam;

public interface ExamService {
    ResultVo save(Exam exam);

    ResultVo update(Exam exam);

    PageBean<Exam> queryAll();

    int queryCount();
}
