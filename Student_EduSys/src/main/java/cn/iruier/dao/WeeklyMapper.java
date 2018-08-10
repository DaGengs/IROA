package cn.iruier.dao;

import java.util.List;

import cn.iruier.entity.Student;
import cn.iruier.entity.Weekly;

public interface WeeklyMapper {
    public int save(Weekly weekly);

    public List<Weekly> queryByName(String name);
}
