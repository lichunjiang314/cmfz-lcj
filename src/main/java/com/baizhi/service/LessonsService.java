package com.baizhi.service;

import com.baizhi.entity.Lessons;

import java.util.List;

public interface LessonsService {
    Long findTotals();
    List<Lessons> findByPage(Integer page, Integer rows);
    void add(Lessons lessons);
    void motify(Lessons lessons);
}
