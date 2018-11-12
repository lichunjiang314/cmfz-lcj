package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    User login(User user);
    void regist(User user);
    void motify(User user);
}
