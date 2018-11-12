package com.baizhi.entity;

public class Counter {
    private int id;
    private String name;
    private int count;
    private String date;
    private int lid;

    public Counter() {
    }

    public Counter(int id, String name, int count, String date, int lid) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.date = date;
        this.lid = lid;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", date='" + date + '\'' +
                ", lid=" + lid +
                '}';
    }
}
