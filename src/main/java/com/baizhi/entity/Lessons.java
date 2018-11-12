package com.baizhi.entity;

import java.util.List;

public class Lessons {
    private int id;
    private String name;
    private String date;
    private int score;
    private boolean status;
    private int uid;
    private List<Counter> children;

    public Lessons() {
    }

    public Lessons(int id, String name, String date, int score, boolean status, int uid, List<Counter> children) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.score = score;
        this.status = status;
        this.uid = uid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<Counter> getChildren() {
        return children;
    }

    public void setChildren(List<Counter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", score=" + score +
                ", status=" + status +
                ", uid=" + uid +
                ", children=" + children +
                '}';
    }
}
