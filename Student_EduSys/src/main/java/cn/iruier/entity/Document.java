package cn.iruier.entity;

import java.util.Date;

/***
 *
 * @ClassName: Document
 * @Description: t_document证件表映射类
 * @author 耿江华
 * @date 2018年6月24日
 *
 */
public class Document {
    private int doc_id;
    private String doc_no;
    private String doc_imgUrl;
    private Date startTime;
    private Date endTime;
    private int status;
    private User user;
    private DocType docType;

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getDoc_no() {
        return doc_no;
    }

    public void setDoc_no(String doc_no) {
        this.doc_no = doc_no;
    }

    public String getDoc_imgUrl() {
        return doc_imgUrl;
    }

    public void setDoc_imgUrl(String doc_imgUrl) {
        this.doc_imgUrl = doc_imgUrl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }
}
