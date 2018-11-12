package com.baizhi.controller;

import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baizhi.service.AdminService;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request,String code){
        HttpSession session = request.getSession();
        String validationCode = (String) session.getAttribute("validationCode");
        Admin admin1 = adminService.login(admin);
        if(validationCode.equals(code)){
            if(admin1.getPassword().equals(admin.getPassword())){
                session.setAttribute("admin",admin1);
                return "redirect:/back/main/main.jsp";
            }else{
                return "redirect:/back/login.jsp";
            }
        }else{
            return "redirect:/back/login.jsp";
        }
    }

    @RequestMapping("exit")
    public String exit(HttpSession session, SessionStatus status){
        status.setComplete();
        session.removeAttribute("admin");
        session.invalidate();
        return "redirect:/back/login.jsp";
    }

    @RequestMapping("edit")
    public String edit(Admin admin,String newPassword){
        admin.setPassword(newPassword);
        adminService.edit(admin);
        return "redirect:/back/login.jsp";
    }
}
