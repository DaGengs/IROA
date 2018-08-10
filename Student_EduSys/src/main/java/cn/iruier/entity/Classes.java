package cn.iruier.entity;

import java.util.List;

/***
 *
 * @ClassName: Classes
 * @Description: t_classes班级表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Classes {
    private int class_id;
    private String class_name;
    private String remark;
    private Subject subject;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
