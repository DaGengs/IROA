package cn.iruier.entity;

/***
 *
 * @ClassName: t_contacts
 * @Description: t_contacts紧急联系人表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Contact {
    private int cont_id;
    private String user_no;
    private String cont_name;
    private String cont_rel;
    private String cont_addr;
    private String cont_phone;
    private int status;

    public int getCont_id() {
        return cont_id;
    }

    public void setCont_id(int cont_id) {
        this.cont_id = cont_id;
    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
    }

    public String getCont_rel() {
        return cont_rel;
    }

    public void setCont_rel(String cont_rel) {
        this.cont_rel = cont_rel;
    }

    public String getCont_addr() {
        return cont_addr;
    }

    public void setCont_addr(String cont_addr) {
        this.cont_addr = cont_addr;
    }

    public String getCont_phone() {
        return cont_phone;
    }

    public void setCont_phone(String cont_phone) {
        this.cont_phone = cont_phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
