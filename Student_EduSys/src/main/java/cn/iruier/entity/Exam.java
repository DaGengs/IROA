package cn.iruier.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Exam {
    private int exam_id;
    private String exam_title;
    private String exam_content;
    private String user_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String exam_type;

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_title() {
        return exam_title;
    }

    public void setExam_title(String exam_title) {
        this.exam_title = exam_title;
    }

    public String getExam_content() {
        return exam_content;
    }

    public void setExam_content(String exam_content) {
        this.exam_content = exam_content;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getExam_type() {
        return exam_type;
    }

    public void setExam_type(String exam_type) {
        this.exam_type = exam_type;
    }

    @Override
    public String toString() {
        return "Exam [exam_id=" + exam_id + ", exam_title=" + exam_title + ", exam_content=" + exam_content
                + ", user_name=" + user_name + ", createtime=" + createtime + ", exam_type=" + exam_type + "]";
    }

}
