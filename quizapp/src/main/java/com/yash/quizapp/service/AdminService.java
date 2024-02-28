package com.yash.quizapp.service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yash.quizapp.Admin;
import com.yash.quizapp.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    @Autowired
    AdminDao adminDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void createAdmin(Admin admin){

        // encrypting the password before storing it in the database
        String encryptedPass = passwordEncoder.encode(admin.getHashed_password());
        admin.setHashed_password(encryptedPass);
        adminDao.save(admin);
    }

    // verify passWord
    public boolean verifyPassword(String password , Admin admin){
        return passwordEncoder.matches(password, admin.getHashed_password());
    }

    // get Admin by Email
    public Admin getAdminByEmail(String email){
        Admin admin = adminDao.getAdminByEmail(email);
        return admin;
    }
}
