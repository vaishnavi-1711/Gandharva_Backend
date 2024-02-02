package com.ts.controller;

import org.springframework.web.bind.annotation.*;

import com.ts.model.Admin;
import com.ts.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/find/{username}")
    public Admin findAdminByUsername(@PathVariable String username) {
        return adminService.findAdminByUsername(username);
    }

    @GetMapping("/find-by-role/{role}")
    public List<Admin> findAdminsByRole(@PathVariable String role) {
        return adminService.findAdminsByRole(role);
    }

    @GetMapping("/find-by-role-ordered/{role}")
    public List<Admin> findAdminsByRoleOrderedByUsernameAsc(@PathVariable String role) {
        return adminService.findAdminsByRoleOrderedByUsernameAsc(role);
    }

    @GetMapping("/count-by-role/{role}")
    public long countAdminsByRole(@PathVariable String role) {
        return adminService.countAdminsByRole(role);
    }

    @GetMapping("/find-by-role-and-username-containing")
    public List<Admin> findAdminsByRoleAndUsernameContaining(
            @RequestParam String role,
            @RequestParam String username) {
        return adminService.findAdminsByRoleAndUsernameContaining(role, username);
    }

    @GetMapping("/find-by-multiple-roles")
    public List<Admin> findAdminsByMultipleRoles(@RequestParam List<String> roles) {
        return adminService.findAdminsByMultipleRoles(roles);
    }

    // You can add more controller methods here based on your needs
}
