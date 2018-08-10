package cn.iruier.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.iruier.common.utils.HttpUtils;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.LoginLogMapper;
import cn.iruier.entity.LoginLog;
import cn.iruier.service.LoginLogService;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper mapper;

    @Override
    public void save(String empl_no) {
        LoginLog loginlog = new LoginLog();
        loginlog.setCreatetime(new Date());
        String json = HttpUtils.getLocation("http://ip.chinaz.com/getip.aspx");
        JSONObject jo = new JSONObject(json);
        loginlog.setIp(jo.getString("ip"));
        loginlog.setEmpl_no(empl_no);
        loginlog.setLocation(jo.getString("address").substring(0, jo.getString("address").indexOf(" ")));
        mapper.save(loginlog);
    }

    @Override
    public PageVo<LoginLog> queryByNo(String empl_no) {
        PageVo<LoginLog> pageVo = new PageVo<>();
        if (StringUtils.empty(empl_no)) {
            List<LoginLog> logs = mapper.queryByNo(empl_no);
            if (logs != null) {
                pageVo.setCode(0);
                pageVo.setData(logs);
                pageVo.setMsg("");
            } else {
                pageVo.setCode(0);
                pageVo.setData(new ArrayList<>());
                pageVo.setMsg("数据异常");
            }
        }
        return pageVo;

    }

}
