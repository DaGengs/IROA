package cn.iruier.entity;

/***
 *
 * @ClassName: Weekly
 * @Description: t_weekly周报表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Weekly {
    private int week_id;
    private String stu_name;
    private String week_title;
    private String week_content;
    private String createtime;
    private int status;
    private Student student;

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getWeek_id() {
        return week_id;
    }

    public void setWeek_id(int week_id) {
        this.week_id = week_id;
    }

    public String getWeek_title() {
        return week_title;
    }

    public void setWeek_title(String week_title) {
        this.week_title = week_title;
    }

    public String getWeek_content() {
        return week_content;
    }

    public void setWeek_content(String week_content) {
        this.week_content = week_content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
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

    @Override
    public String toString() {
        return "Weekly [week_id=" + week_id + ", week_title=" + week_title + ", week_content=" + week_content
                + ", createtime=" + createtime + ", status=" + status + ", student=" + student + "]";
    }

}
