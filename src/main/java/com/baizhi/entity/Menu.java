package com.baizhi.entity;

import java.util.List;

public class Menu {
    private int id;
    private String name;
    private String herf;
    private String iconCls;
    private List<Menu> menus;

    public Menu() {
    }

    public Menu(int id, String name, String herf, String iconCls, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.herf = herf;
        this.iconCls = iconCls;
        this.menus = menus;
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

    public String getHerf() {
        return herf;
    }

    public void setHerf(String herf) {
        this.herf = herf;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", herf='" + herf + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", menus=" + menus +
                '}';
    }
}