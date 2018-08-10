package cn.iruier.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
    private String empl_no;
    private String empl_name;
    private String empl_phone;
    private String empl_gender;
    private String empl_email;
    private String empl_imgUrl;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private int dept_id;
    private int status;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmpl_no() {
        return empl_no;
    }

    public void setEmpl_no(String empl_no) {
        this.empl_no = empl_no;
    }

    public String getEmpl_name() {
        return empl_name;
    }

    public void setEmpl_name(String empl_name) {
        this.empl_name = empl_name;
    }

    public String getEmpl_phone() {
        return empl_phone;
    }

    public void setEmpl_phone(String empl_phone) {
        this.empl_phone = empl_phone;
    }

    public String getEmpl_gender() {
        return empl_gender;
    }

    public void setEmpl_gender(String empl_gender) {
        this.empl_gender = empl_gender;
    }

    public String getEmpl_email() {
        return empl_email;
    }

    public void setEmpl_email(String empl_email) {
        this.empl_email = empl_email;
    }

    public String getEmpl_imgUrl() {
        return empl_imgUrl;
    }

    public void setEmpl_imgUrl(String empl_imgUrl) {
        this.empl_imgUrl = empl_imgUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
