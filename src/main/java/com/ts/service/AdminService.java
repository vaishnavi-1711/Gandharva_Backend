package com.ts.service;

import com.ts.dao.AdminDao;
import com.ts.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public List<Admin> getAllAdmins() {
        return adminDao.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin not found with id " + id));
    }

    public ResponseEntity<String> authenticate(Admin request) {
        String username = request.getUsername();
        String password = request.getPassword();

        Optional<Admin> optionalAdmin = adminDao.findByUsername(username);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            if (admin.getPassword().equals(password)) {
                return ResponseEntity.ok("Authentication successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }

    public ResponseEntity<Admin> addAdmin(Admin admin) {
        Admin savedAdmin = adminDao.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }

    public ResponseEntity<Admin> updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminDao.findById(id)
                              .orElseThrow(() -> new IllegalArgumentException("Admin not found with id " + id));

        admin.setUsername(adminDetails.getUsername());
        admin.setPassword(adminDetails.getPassword());

        Admin updatedAdmin = adminDao.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    public ResponseEntity<Void> deleteAdmin(Long id) {
        adminDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}