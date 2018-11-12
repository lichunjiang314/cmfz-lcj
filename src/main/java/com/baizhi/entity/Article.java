package com.baizhi.entity;

public class Article {
    private int id;
    private String name;
    private String content;
    private String date;
    private String img;
    private String author;

    public Article() {
    }

    public Article(int id, String name, String content, String date, String img, String author) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.img = img;
        this.author = author;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", img='" + img + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}