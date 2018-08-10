package cn.iruier.entity;

/***
 *
 * @ClassName: DocType
 * @Description: t_doc_type证件类型表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class DocType {
    private int type_id;
    private String type_name;

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
