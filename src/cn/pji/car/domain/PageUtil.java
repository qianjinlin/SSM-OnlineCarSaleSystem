package cn.pji.car.domain;

import java.util.List;
/*用于layui表格返回的数据，存储用户发送过来的邮件*/
public class PageUtil {
    private int code;
    private String msg;
    private int count;
    private List<AdminMail> data;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AdminMail> getData() {
        return data;
    }

    public void setData(List<AdminMail> data) {
        this.data = data;
    }
}
