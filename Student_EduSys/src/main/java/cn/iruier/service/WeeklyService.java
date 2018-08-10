package cn.iruier.service;

import cn.iruier.common.vo.PageBean;
import cn.iruier.entity.Student;
import cn.iruier.entity.Weekly;

public interface WeeklyService {
    public boolean save(Weekly weekly);

    public PageBean<Weekly> queryByName(String name);
}
