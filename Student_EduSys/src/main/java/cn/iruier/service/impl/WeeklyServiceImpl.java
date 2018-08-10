package cn.iruier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageBean;
import cn.iruier.dao.WeeklyMapper;
import cn.iruier.entity.Student;
import cn.iruier.entity.Weekly;
import cn.iruier.service.WeeklyService;

@Service
public class WeeklyServiceImpl implements WeeklyService {

    @Autowired
    private WeeklyMapper mapper;

    @Override
    public boolean save(Weekly weekly) {
        return mapper.save(weekly) > 0;
    }

    @Override
    public PageBean<Weekly> queryByName(String name) {
        if (StringUtils.empty(name)) {
            List<Weekly> weeklies = mapper.queryByName(name);
            if (!weeklies.isEmpty()) {
                PageBean<Weekly> pageBean = new PageBean<>();
                pageBean.setCode(0);
                pageBean.setCount(10);
                pageBean.setMsg("");
                pageBean.setData(weeklies);
                return pageBean;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
