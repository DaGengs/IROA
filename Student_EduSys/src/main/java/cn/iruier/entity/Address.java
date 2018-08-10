package cn.iruier.entity;

/***
 *
 * @ClassName: Address
 * @Description: t_address地址表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Address {
    private int addr_id;
    private String user_no;
    private String prov_name;
    private String city_name;
    private String county_name;
    private String addr_detail;
    private String addr_type;
    private int status;

    public int getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(int addr_id) {
        this.addr_id = addr_id;
    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getProv_name() {
        return prov_name;
    }

    public void setProv_name(String prov_name) {
        this.prov_name = prov_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public String getAddr_detail() {
        return addr_detail;
    }

    public void setAddr_detail(String addr_detail) {
        this.addr_detail = addr_detail;
    }

    public String getAddr_type() {
        return addr_type;
    }

    public void setAddr_type(String addr_type) {
        this.addr_type = addr_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
