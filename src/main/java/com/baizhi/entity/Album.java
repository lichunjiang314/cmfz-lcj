package com.baizhi.entity;

import java.util.List;

public class Album {
   private int id;
   private String name;
   private String img;
   private String autho;
   private int star;
   private int count;
   private String broadcast;
   private String date;
   private String brief;
   private List<Chapter> children;

    public Album() {
    }

    public Album(int id, String name, String img, String autho, int star, int count, String broadcast, String date, String brief, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.autho = autho;
        this.star = star;
        this.count = count;
        this.broadcast = broadcast;
        this.date = date;
        this.brief = brief;
        this.children = children;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAutho() {
        return autho;
    }

    public void setAutho(String autho) {
        this.autho = autho;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", autho='" + autho + '\'' +
                ", star=" + star +
                ", count=" + count +
                ", broadcast='" + broadcast + '\'' +
                ", date='" + date + '\'' +
                ", brief='" + brief + '\'' +
                ", children=" + children +
                '}';
    }
}
