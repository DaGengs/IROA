package cn.iruier.service;

import cn.iruier.common.vo.PageBean;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Question;

public interface QuestionService {
    ResultVo save(Question question);

    public PageBean<Question> queryByName(String name);
}
