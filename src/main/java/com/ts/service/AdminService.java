package com.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.AdminDao;
import com.ts.model.Admin;

import java.util.List;


@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin findAdminByUsername(String username) {
        return adminDao.findByUsername(username);
    }

    public List<Admin> findAdminsByRole(String role) {
        return adminDao.findByRole(role);
    }

    public List<Admin> findAdminsByRoleOrderedByUsernameAsc(String role) {
        return adminDao.findByRoleOrderByUsernameAsc(role);
    }

    public long countAdminsByRole(String role) {
        return adminDao.countByRole(role);
    }

    public List<Admin> findAdminsByRoleAndUsernameContaining(String role, String username) {
        return adminDao.findByRoleAndUsernameContaining(role, username);
    }

    public List<Admin> findAdminsByMultipleRoles(List<String> roles) {
        return adminDao.findByRoleIn(roles);
    }


}
