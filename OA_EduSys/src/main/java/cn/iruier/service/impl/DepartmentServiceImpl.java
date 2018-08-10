package cn.iruier.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.DepartmentMapper;
import cn.iruier.entity.Department;
import cn.iruier.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper mapper;

    @Override
    public ResultVo save(Department department) {
        String curr_no = mapper.queryNo();
        if (curr_no == null) {
            curr_no = "1001";
        } else {
            curr_no = (Integer.parseInt(curr_no) + 1) + "";
        }
        department.setDept_id(Integer.parseInt(curr_no));
        department.setDept_level(department.getDept_level() + 1);

        int rows = mapper.save(department);
        if (rows > 0) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public ResultVo update(String dept_name, int dept_id) {
        if (StringUtils.empty(dept_name) && dept_id != 0) {
            int rows = mapper.update(dept_name, dept_id);
            if (rows > 0) {
                return ResultVo.setOK("修改成功");
            } else {
                return ResultVo.setERROR("修改失败");
            }
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete(int dept_id) {
        if (dept_id != 0) {
            int rows = mapper.delete(dept_id);
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
    public PageVo<Department> queryByPage(int page, int size) {
        PageVo<Department> pageVo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * size;
        }
        List<Department> list = mapper.queryByPage(index, size);
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
    public List<Department> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public String queryNo() {
        return mapper.queryNo();
    }


}
