package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    void add(Album album);
    List<Album> findAll();
    Album findById(int id);
    Long findTotals();
    List<Album> findByPage(Integer page, Integer rows);
}
