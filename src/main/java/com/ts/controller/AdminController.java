package com.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ts.model.Admin;
import com.ts.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String response = adminService.login(username, password);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestParam String username, @RequestParam String password) {
        String response = adminService.addAdmin(username, password);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
