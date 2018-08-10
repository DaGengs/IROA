package cn.iruier.service;

import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Complaint;

public interface ComplaintService {
    ResultVo save(Complaint complaint);

}
