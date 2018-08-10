package cn.iruier.service;

import java.util.List;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Department;

public interface DepartmentService {

    ResultVo save(Department department);

    ResultVo update(String dept_name, int dept_id);

    ResultVo delete(int dept_id);

    int queryCount();

    PageVo<Department> queryByPage(int page, int size);

    List<Department> queryAll();

    String queryNo();
}
