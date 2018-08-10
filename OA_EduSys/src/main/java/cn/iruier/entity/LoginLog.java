package cn.iruier.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LoginLog {
    private int id;
    private String ip;
    private String location;
    private String empl_no;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmpl_no() {
        return empl_no;
    }

    public void setEmpl_no(String empl_no) {
        this.empl_no = empl_no;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
