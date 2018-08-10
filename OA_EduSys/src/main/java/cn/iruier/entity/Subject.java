package cn.iruier.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Subject {
    private int subj_id;
    private String subj_name;
    private int subj_week;
    private String subj_type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    private int status;

    public int getSubj_id() {
        return subj_id;
    }

    public void setSubj_id(int subj_id) {
        this.subj_id = subj_id;
    }

    public String getSubj_name() {
        return subj_name;
    }

    public void setSubj_name(String subj_name) {
        this.subj_name = subj_name;
    }

    public int getSubj_week() {
        return subj_week;
    }

    public void setSubj_week(int subj_week) {
        this.subj_week = subj_week;
    }

    public String getSubj_type() {
        return subj_type;
    }

    public void setSubj_type(String subj_type) {
        this.subj_type = subj_type;
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
