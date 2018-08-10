package cn.iruier.entity;

import java.util.List;

/***
 *
 * @ClassName: Subject
 * @Description: t_subject学科表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Subject {
    private int subj_id;
    private String subj_name;
    private String remark;
    private List<Classes> classes;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

}
