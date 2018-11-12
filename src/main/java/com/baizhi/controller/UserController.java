package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.DurationUtil;
import com.baizhi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user){
        User user1 = userService.login(user);
        if(user1.getPassword().equals(user.getPassword())){
            return "";
        }
        return "";
    }

    @RequestMapping("/motify")
    public String motify(User user){
        userService.motify(user);
        return null;
    }

    @RequestMapping("/regist")
    public String regist(User user,String code){
        user.setPassword(MD5Util.encryption(user.getPassword()));
        user.setSalt(code);
        return  null;
    }
}
