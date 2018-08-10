package cn.iruier.service;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.entity.Employee;

public interface EmployeeService {
    ResultVo save(Employee employee);

    ResultVo update(Employee employee);

    ResultVo delete(String empl_no);

    int queryCount();

    PageVo<Employee> queryByPage(int page, int size);

    Employee queryByNo(String empl_no);

    String queryNo();
}
