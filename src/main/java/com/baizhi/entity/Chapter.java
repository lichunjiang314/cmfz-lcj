package com.baizhi.entity;

public class Chapter {
    private int id;
    private String name;
    private double size;
    private String duration;
    private String date;
    private String href;
    private int aid;

    public Chapter() {
    }

    public Chapter(int id, String name, double size, String duration, String date, String href, int aid) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.duration = duration;
        this.date = date;
        this.href = href;
        this.aid = aid;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", duration='" + duration + '\'' +
                ", date='" + date + '\'' +
                ", href='" + href + '\'' +
                ", aid=" + aid +
                '}';
    }
}
