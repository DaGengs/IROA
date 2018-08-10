package cn.iruier.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Department {
    private int dept_id;
    private String dept_name;
    private int dept_p_id;
    private int dept_level;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    private int status;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getDept_p_id() {
        return dept_p_id;
    }

    public void setDept_p_id(int dept_p_id) {
        this.dept_p_id = dept_p_id;
    }

    public int getDept_level() {
        return dept_level;
    }

    public void setDept_level(int dept_level) {
        this.dept_level = dept_level;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
