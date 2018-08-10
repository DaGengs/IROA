package cn.iruier.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.ClassesMapper;
import cn.iruier.entity.Classes;
import cn.iruier.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper mapper;

    @Override
    public ResultVo save(Classes classes) {
        int subj_id = classes.getSubj_id();
        String class_no = mapper.queryNoBysubId(classes.getSubj_id());
        if (class_no == null) {
            class_no = subj_id + "" + "1001";
        } else {
            class_no = (Integer.parseInt(class_no) + 1) + "";
        }
        classes.setClass_no(class_no);

        int rows = mapper.save(classes);
        if (rows > 0) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public ResultVo update(Classes classes) {
        int rows = mapper.update(classes);
        if (rows > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete(String no) {
        if (StringUtils.empty(no)) {
            int rows = mapper.delete(no);
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
    public PageVo<Classes> queryByPage(int page, int size) {
        PageVo<Classes> pageVo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * size;
        }
        List<Classes> classes = mapper.queryByPage(index, size);
        if (classes != null) {
            pageVo.setCode(0);
            pageVo.setCount(mapper.queryCount());
            pageVo.setMsg("");
            pageVo.setData(classes);
        } else {
            pageVo.setCode(1);
            pageVo.setCount(0);
            pageVo.setMsg("暂无数据");
            pageVo.setData(new ArrayList<>());
        }
        return pageVo;
    }

    @Override
    public List<Classes> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public String queryNoBysubId(int subj_id) {
        return mapper.queryNoBysubId(subj_id);
    }

}
