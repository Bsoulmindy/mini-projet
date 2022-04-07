package com.terroir.controllers;

import com.terroir.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    
    @Autowired
    AdminService  adminService;

    
}
