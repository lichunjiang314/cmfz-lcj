package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    Guru findById(int id);
    List<Guru> findByPage(Integer page, Integer rows);
    Long findTotals();
    void add(Guru guru);
    void remove(int id);
    void motify(Guru guru);
}
