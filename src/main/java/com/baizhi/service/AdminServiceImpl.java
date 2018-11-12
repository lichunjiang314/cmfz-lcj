package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Transactional(propagation=Propagation.SUPPORTS)
    public Admin login(Admin admin){
        String name = admin.getName();
        return adminDAO.queryByOne(name);
    }

    @Override
    public void edit(Admin admin) {
        adminDAO.update(admin);
    }
}
