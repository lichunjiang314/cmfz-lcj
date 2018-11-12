package com.baizhi.entity;

public class SowingMap {
    private int id;
    private String title;
    private String imgPath;
    private String date;
    private boolean status;
    private String description;

    public SowingMap() {
    }

    public SowingMap(int id, String title, String imgPath, String date, boolean status, String description) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SowingMap{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
