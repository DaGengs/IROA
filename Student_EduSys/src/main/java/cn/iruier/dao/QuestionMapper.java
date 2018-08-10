package cn.iruier.dao;

import java.util.List;

import cn.iruier.entity.Question;

public interface QuestionMapper {
    public int save(Question question);

    public List<Question> queryByName(String name);
}
