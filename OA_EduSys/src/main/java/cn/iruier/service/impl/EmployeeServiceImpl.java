package cn.iruier.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.ClassesMapper;
import cn.iruier.dao.EmployeeMapper;
import cn.iruier.entity.Classes;
import cn.iruier.entity.Employee;
import cn.iruier.service.ClassesService;
import cn.iruier.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public ResultVo save(Employee employee) {
        String curr_no = mapper.queryNo();
        int dept_no = employee.getDept_id();
        String empl_no = "";
        if (curr_no == null) {
            empl_no = dept_no + "" + 1001;
        } else {
            empl_no = ((Integer.parseInt(curr_no)) + 1) + "";
        }
        employee.setEmpl_no(empl_no);
        int rows = mapper.save(employee);
        if (rows > 0) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public ResultVo update(Employee employee) {

        int rows = mapper.update(employee);
        if (rows > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete(String empl_no) {
        if (StringUtils.empty(empl_no)) {
            int rows = mapper.delete(empl_no);
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
    public PageVo<Employee> queryByPage(int page, int size) {
        PageVo<Employee> pageVo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * size;
        }
        List<Employee> empls = mapper.queryByPage(index, size);
        if (empls != null) {
            pageVo.setCode(0);
            pageVo.setCount(mapper.queryCount());
            pageVo.setMsg("");
            pageVo.setData(empls);
        } else {
            pageVo.setCode(1);
            pageVo.setCount(0);
            pageVo.setMsg("暂无数据");
            pageVo.setData(new ArrayList<>());
        }
        return pageVo;
    }

    @Override
    public Employee queryByNo(String empl_no) {
        if (StringUtils.empty(empl_no)) {
            return mapper.queryByno(empl_no);
        }
        return null;
    }

    @Override
    public String queryNo() {
        return mapper.queryNo();
    }

}
