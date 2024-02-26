package com.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.AdminDao;
import com.ts.model.Admin;

@Service
public class AdminService {
    private static final String FIRST_ADMIN_USERNAME = "admin";
    private static final String FIRST_ADMIN_PASSWORD = "1234";

    private static boolean firstAdminLoggedIn = false;

    @Autowired
    private AdminDao adminDao;

    public Admin getAdminById(Long id) {
        return adminDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin not found with id " + id));
    }

    public String login(String username, String password) {
        return authenticate(username, password);
    }

    public String addAdmin(String username, String password) {
        if (firstAdminLoggedIn) {
            return "Only the first admin can add new login details.";
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        adminDao.save(admin);

        firstAdminLoggedIn = true;
        return "Admin added successfully.";
    }

    private String authenticate(String username, String password) {
        if (firstAdminLoggedIn) {
            return "Only the first admin can add new login details.";
        }

        if (username.equals(FIRST_ADMIN_USERNAME) && password.equals(FIRST_ADMIN_PASSWORD)) {
            firstAdminLoggedIn = true;
            return "Admin logged in successfully.";
        } else {
            return "Invalid username or password.";
        }
    }
}
