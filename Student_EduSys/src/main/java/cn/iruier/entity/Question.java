package cn.iruier.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/***
 *
 * @ClassName: Question
 * @Description: t_question问题表
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Question {
    private int ques_id;
    private String stu_name;
    private String ques_content;
    private String ques_reply;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private int status;
    private Student student;

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getQues_id() {
        return ques_id;
    }

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    public String getQues_content() {
        return ques_content;
    }

    public void setQues_content(String ques_content) {
        this.ques_content = ques_content;
    }

    public String getQues_reply() {
        return ques_reply;
    }

    public void setQues_reply(String ques_reply) {
        this.ques_reply = ques_reply;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
