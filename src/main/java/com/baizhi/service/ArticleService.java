package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findByPage(Integer page, Integer rows);
    Long findTotals();
    void add(Article article);
    void remove(int id);
    void motify(Article article);
}
