package cn.iruier.entity;

import java.util.List;

/***
 *
 * @ClassName: User
 * @Description: t_user用户表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class User {
    private int user_id;
    private String user_no;
    private String user_idNumber;
    private String user_password;
    private String user_name;
    private int status;
    private List<Role> roles;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getUser_idNumber() {
        return user_idNumber;
    }

    public void setUser_idNumber(String user_idNumber) {
        this.user_idNumber = user_idNumber;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
