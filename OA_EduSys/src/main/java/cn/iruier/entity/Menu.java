package cn.iruier.entity;

import java.util.List;

public class Menu {

    private int menu_id;
    private String menu_name;
    private String menu_url;
    private String menu_icon;
    private int menu_p_id;
    private String menu_p_name;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getMenu_p_name() {
        return menu_p_name;
    }

    public void setMenu_p_name(String menu_p_name) {
        this.menu_p_name = menu_p_name;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public int getMenu_p_id() {
        return menu_p_id;
    }

    public void setMenu_p_id(int menu_p_id) {
        this.menu_p_id = menu_p_id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_p_id=" + menu_p_id +
                ", menu_p_name='" + menu_p_name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
