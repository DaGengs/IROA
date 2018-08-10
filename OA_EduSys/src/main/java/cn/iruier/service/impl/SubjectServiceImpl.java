package cn.iruier.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.DepartmentMapper;
import cn.iruier.dao.SubjectMapper;
import cn.iruier.entity.Department;
import cn.iruier.entity.Subject;
import cn.iruier.service.DepartmentService;
import cn.iruier.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper mapper;

    @Override
    public ResultVo save(Subject subject) {
        String subj_id = mapper.queryNo();
        if (subj_id == null) {
            subj_id = "1001";
        } else {
            subj_id = (Integer.parseInt(subj_id) + 1) + "";
        }
        subject.setSubj_id(Integer.parseInt(subj_id));

        int rows = mapper.save(subject);
        if (rows > 0) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public ResultVo update(Subject subject) {
        int rows = mapper.update(subject);
        if (rows > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete(int subj_id) {
        if (subj_id != 0) {
            int rows = mapper.delete(subj_id);
            if (rows > 0) {
                return ResultVo.setOK("删除成功");
            } else {
                return ResultVo.setERROR("删除失败");
            }
        } else {
            return ResultVo.setERROR("删除失败");
        }
    }

    @Override
    public int queryCount() {
        return mapper.queryCount();
    }

    @Override
    public PageVo<Subject> queryByPage(int page, int size) {
        PageVo<Subject> pageVo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * size;
        }
        List<Subject> list = mapper.queryByPage(index, size);
        if (list != null) {
            pageVo.setCode(0);
            pageVo.setCount(mapper.queryCount());
            pageVo.setMsg("");
            pageVo.setData(list);
        } else {
            pageVo.setCode(1);
            pageVo.setCount(0);
            pageVo.setMsg("暂无数据");
            pageVo.setData(new ArrayList<>());
        }
        return pageVo;
    }

    @Override
    public List<Subject> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public String queryNo() {
        return mapper.queryNo();
    }

}
