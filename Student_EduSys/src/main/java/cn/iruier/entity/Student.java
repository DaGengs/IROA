package cn.iruier.entity;

import java.util.Date;
import java.util.List;

/***
 *
 * @ClassName: Student
 * @Description: t_student学生表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Student {
    private String stu_no;
    private String stu_idNumber;
    private String stu_name;
    private String stu_gender;
    private String stu_phone;
    private String stu_QQ;
    private String stu_schoolName;
    private String stu_education;
    private String class_no;
    private String stu_introno;
    private String stu_origin;
    private String card_pre;
    private String card_suf;
    private String photo_url;
    private String createtime;
    private int status;
    private Classes classes;
    private Contact contact;
    private Address address;

    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_idNumber() {
        return stu_idNumber;
    }

    public void setStu_idNumber(String stu_idNumber) {
        this.stu_idNumber = stu_idNumber;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(String stu_gender) {
        this.stu_gender = stu_gender;
    }

    public String getStu_phone() {
        return stu_phone;
    }

    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    public String getStu_QQ() {
        return stu_QQ;
    }

    public void setStu_QQ(String stu_QQ) {
        this.stu_QQ = stu_QQ;
    }

    public String getStu_schoolName() {
        return stu_schoolName;
    }

    public void setStu_schoolName(String stu_schoolName) {
        this.stu_schoolName = stu_schoolName;
    }

    public String getStu_education() {
        return stu_education;
    }

    public void setStu_education(String stu_education) {
        this.stu_education = stu_education;
    }

    public String getClass_no() {
        return class_no;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public String getStu_introno() {
        return stu_introno;
    }

    public void setStu_introno(String stu_introno) {
        this.stu_introno = stu_introno;
    }

    public String getStu_origin() {
        return stu_origin;
    }

    public void setStu_origin(String stu_origin) {
        this.stu_origin = stu_origin;
    }

    public String getCard_pre() {
        return card_pre;
    }

    public void setCard_pre(String card_pre) {
        this.card_pre = card_pre;
    }

    public String getCard_suf() {
        return card_suf;
    }

    public void setCard_suf(String card_suf) {
        this.card_suf = card_suf;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
