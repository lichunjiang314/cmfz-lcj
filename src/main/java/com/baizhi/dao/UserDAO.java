package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO  {
    void insert(User user);
    void update(User user);
    User queryOne(String phone);
}
