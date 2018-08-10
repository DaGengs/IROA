package cn.iruier.entity;

/***
 *
 * @ClassName: Complaint
 * @Description: t_complaint投诉表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Complaint {
    private int comp_id;
    private String comp_content;
    private String createtime;
    private int status;

    public int getComp_id() {
        return comp_id;
    }

    public void setComp_id(int comp_id) {
        this.comp_id = comp_id;
    }

    public String getComp_content() {
        return comp_content;
    }

    public void setComp_content(String comp_content) {
        this.comp_content = comp_content;
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
}
