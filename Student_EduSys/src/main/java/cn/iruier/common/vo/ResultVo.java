package cn.iruier.common.vo;

import java.util.List;

//统一结果集  主要是针对非查询操作的数据返回  json
public class ResultVo {
    private int code;// 成功 1 失败 0
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultVo(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultVo() {
        super();
    }

    public static ResultVo setOK(String msg) {
        return new ResultVo(1, msg);
    }

    public static ResultVo setERROR(String msg) {
        return new ResultVo(0, msg);
    }

}
