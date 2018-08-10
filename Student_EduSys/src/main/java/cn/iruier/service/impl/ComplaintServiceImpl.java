package cn.iruier.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.ComplaintMapper;
import cn.iruier.entity.Complaint;
import cn.iruier.service.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper mapper;

    @Override
    public ResultVo save(Complaint complaint) {
        if (mapper.save(complaint) > 0) {
            return ResultVo.setOK("提交成功");
        } else {
            return ResultVo.setERROR("提交失败");
        }
    }

}
