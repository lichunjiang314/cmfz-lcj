package com.baizhi.entity;

public class Admin {
    private String id;
    private String name;
    private String password;
    private int jurisdiction;

    public Admin() {
    }

    public Admin(String id, String name, String password, int jurisdiction) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.jurisdiction = jurisdiction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", jurisdiction=" + jurisdiction +
                '}';
    }
}
