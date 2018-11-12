package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        String phone = user.getPhone();
        return userDAO.queryOne(phone);
    }

    @Override
    public void regist(User user) {
        userDAO.insert(user);
    }

    @Override
    public void motify(User user) {
        userDAO.update(user);
    }
}
