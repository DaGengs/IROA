package cn.iruier.dao;

import java.util.List;

import cn.iruier.entity.Exam;

public interface ExamMapper {
    int save(Exam exam);

    int update(Exam exam);

    List<Exam> queryAll();

    int queryCount();
}
