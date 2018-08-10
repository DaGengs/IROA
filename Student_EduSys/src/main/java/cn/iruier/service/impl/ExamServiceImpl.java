package cn.iruier.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.vo.PageBean;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.ExamMapper;
import cn.iruier.entity.Exam;
import cn.iruier.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper mapper;

    @Override
    public ResultVo save(Exam exam) {
        if (mapper.save(exam) > 0) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public ResultVo update(Exam exam) {
        if (mapper.update(exam) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public PageBean<Exam> queryAll() {
        PageBean<Exam> pageBean = new PageBean<>();
        List<Exam> exams = mapper.queryAll();
        if (exams != null) {
            pageBean.setCode(0);
            pageBean.setCount(mapper.queryCount());
            pageBean.setData(exams);
            pageBean.setMsg("");
        } else {
            pageBean.setCode(1);
            pageBean.setCount(0);
            pageBean.setData(new ArrayList<>());
            pageBean.setMsg("暂无数据");
        }
        return pageBean;
    }

    @Override
    public int queryCount() {
        return mapper.queryCount();
    }

}
