package cn.iruier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.StudentMapper;
import cn.iruier.entity.Student;
import cn.iruier.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public ResultVo update(Student student) {
        int rows = mapper.update(student);
        if (rows > 0) {
            return ResultVo.setOK("保存成功");
        } else {
            return ResultVo.setERROR("保存失败");
        }
    }

    public Student queryByNo(String no) {
        if (StringUtils.empty(no)) {
            return mapper.queryByNo(no);
        } else {
            return null;
        }
    }


}
