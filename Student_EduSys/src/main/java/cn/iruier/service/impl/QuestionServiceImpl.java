package cn.iruier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageBean;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.QuestionMapper;
import cn.iruier.dao.WeeklyMapper;
import cn.iruier.entity.Question;
import cn.iruier.entity.Student;
import cn.iruier.entity.Weekly;
import cn.iruier.service.QuestionService;
import cn.iruier.service.WeeklyService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper mapper;

    @Override
    public ResultVo save(Question question) {
        if (mapper.save(question) > 0) {
            return ResultVo.setOK("提交成功");
        } else {
            return ResultVo.setERROR("提交失败");
        }
    }

    @Override
    public PageBean<Question> queryByName(String name) {
        if (StringUtils.empty(name)) {
            List<Question> questions = mapper.queryByName(name);
            if (!questions.isEmpty()) {
                PageBean<Question> pageBean = new PageBean<>();
                pageBean.setCode(0);
                pageBean.setCount(10);
                pageBean.setMsg("");
                pageBean.setData(questions);
                return pageBean;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
