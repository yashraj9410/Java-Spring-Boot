package com.yash.quizapp.controller;

import com.yash.quizapp.Admin;
import com.yash.quizapp.LoginDTO;
import com.yash.quizapp.service.AdminService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("admin")
public class AdminController {


    @Autowired
    AdminService adminService;


    // signup controller
    @PostMapping("/signup")
    public ResponseEntity<?> adminSignup(@RequestBody Admin admin ) {
        Map<String,String> response  = new HashMap<>();
        try{
            response.put("status", "201");
            response.put("message", "Admin Created");
            adminService.createAdmin(admin);
            return ResponseEntity.ok(response);

        }
        catch(Exception e){
            return ResponseEntity.status(500).body(e);
        }
    }


    // admin login
    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestBody LoginDTO login){
        try{
            String email = login.getEmail();
            String password = login.getPassword();

            // check if user exists with email
            Admin admin = adminService.getAdminByEmail(email);
            if(admin != null){
                if(adminService.verifyPassword(password,admin)){
                    // login Success
                    return ResponseEntity.ok("Logged in success");
                    // token sign and send to header for further authentication
                }
                return ResponseEntity.status(402).body("Password Doesw not match ");
            }
            return ResponseEntity.status(404).body("Admin does not exist for the given email");

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }


}
