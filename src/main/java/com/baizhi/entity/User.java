package com.baizhi.entity;

import java.util.List;

public class User {
    private int id;
    private String phone;
    private String username;
    private String password;
    private String salt;
    private String dharmllame;
    private String sex;
    private String headpic;
    private String provence;
    private String city;
    private String sign;
    private boolean status;
    private String date;
    private List<Lessons> children;

    public User() {
    }

    public User(int id, String phone, String username, String password, String salt, String dharmllame, String sex, String headpic, String provence, String city, String sign, boolean status, String date, List<Lessons> children) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.dharmllame = dharmllame;
        this.sex = sex;
        this.headpic = headpic;
        this.provence = provence;
        this.city = city;
        this.sign = sign;
        this.status = status;
        this.date = date;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDharmllame() {
        return dharmllame;
    }

    public void setDharmllame(String dharmllame) {
        this.dharmllame = dharmllame;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getProvence() {
        return provence;
    }

    public void setProvence(String provence) {
        this.provence = provence;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Lessons> getChildren() {
        return children;
    }

    public void setChildren(List<Lessons> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", dharmllame='" + dharmllame + '\'' +
                ", sex='" + sex + '\'' +
                ", headpic='" + headpic + '\'' +
                ", provence='" + provence + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", status=" + status +
                ", date='" + date + '\'' +
                ", children=" + children +
                '}';
    }
}
