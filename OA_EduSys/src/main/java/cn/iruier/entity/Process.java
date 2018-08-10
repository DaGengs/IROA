package cn.iruier.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Process {
    private int id;
    private String applyName;
    private String applyNo;
    private String type;
    private String info;
    private String pid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int days;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", applyName='" + applyName + '\'' +
                ", applyNo='" + applyNo + '\'' +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", pid='" + pid + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", days=" + days +
                ", status=" + status +
                '}';
    }
}
