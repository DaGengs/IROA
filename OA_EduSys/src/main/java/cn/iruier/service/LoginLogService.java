package cn.iruier.service;

import cn.iruier.common.vo.PageVo;
import cn.iruier.entity.LoginLog;

public interface LoginLogService {
    void save(String empl_no);

    PageVo<LoginLog> queryByNo(String empl_no);
}
