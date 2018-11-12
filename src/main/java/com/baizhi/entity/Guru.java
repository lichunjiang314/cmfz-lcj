package com.baizhi.entity;

public class Guru {
    private int id;
    private String name;
    private String headpic;
    private String sex;

    public Guru() {
    }

    public Guru(int id, String name, String headpic, String sex) {
        this.id = id;
        this.name = name;
        this.headpic = headpic;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headpic='" + headpic + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
