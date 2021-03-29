package cn.pji.car.domain;

public class User {
    private int id;
    private String isSeller;
    private String identitys;
    private String nickname;
    private String sex;
    private String mail;
    private String time;
    private String phone;
    private String username;
    private String password;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String imgUrl;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setIsSeller(String isSeller) {
        this.isSeller = isSeller;
    }
    public void setIdentitys(String identitys) {
        this.identitys = identitys;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getIsSeller() {
        return isSeller;
    }
    public String getIdentitys() {
        return identitys;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSex() {
        return sex;
    }

    public String getMail() {
        return mail;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
