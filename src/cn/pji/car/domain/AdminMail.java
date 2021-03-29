package cn.pji.car.domain;

public class AdminMail {
    private int id;
    private String sendMailer;
    private String message;
    private String mailTime;
    private String status;
    private String msgTheme;

    public String getMsgTheme() {
        return msgTheme;
    }

    public void setMsgTheme(String msgTheme) {
        this.msgTheme = msgTheme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSendMailer() {
        return sendMailer;
    }

    public void setSendMailer(String sendMailer) {
        this.sendMailer = sendMailer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMailTime() {
        return mailTime;
    }

    public void setMailTime(String mailTime) {
        this.mailTime = mailTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
