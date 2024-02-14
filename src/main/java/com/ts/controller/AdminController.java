package com.ts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	    @PostMapping("/add")
	    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
	        Admin newAdmin = adminService.addAdmin(admin);
	        return ResponseEntity.status(HttpStatus.CREATED).body(newAdmin);
	    }

	    @GetMapping
	    public ResponseEntity<List<Admin>> getAllAdmins() {
	        List<Admin> admins = adminService.getAllAdmins();
	        return ResponseEntity.ok(admins);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
	        Admin admin = adminService.getAdminById(id);
	        return ResponseEntity.ok(admin);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
	        Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
	        return ResponseEntity.ok(updatedAdmin);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
	        adminService.deleteAdmin(id);
	        return ResponseEntity.noContent().build();
	    }
	}

