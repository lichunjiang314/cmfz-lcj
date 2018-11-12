package com.baizhi.service;

import com.baizhi.entity.SowingMap;

import java.util.List;

public interface SowingMapService {
    SowingMap findById(int id);
    List<SowingMap> findByPage(Integer page, Integer rows);
    Long findTotals();
    void add(SowingMap sowingMap);
    void remove(int id);
    void motify(SowingMap sowingMap);

}
