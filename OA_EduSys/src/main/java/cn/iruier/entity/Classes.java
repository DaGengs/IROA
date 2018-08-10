package cn.iruier.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Classes {
    private int class_id;
    private String class_no;
    private String class_name;
    private int subj_id;
    private int class_week;
    private int count;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getClass_week() {
        return class_week;
    }

    public void setClass_week(int class_week) {
        this.class_week = class_week;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_no() {
        return class_no;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getSubj_id() {
        return subj_id;
    }

    public void setSubj_id(int subj_id) {
        this.subj_id = subj_id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
