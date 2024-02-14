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


	    

	     public AdminService( AdminDao adminDao ) {
	         this. adminDao =  adminDao;
	     }

	     public Admin addAdmin(Admin admin) {
	         return  adminDao.save(admin);
	     }

	     public List<Admin> getAllAdmins() {
	         return  adminDao.findAll();
	     }

	     public Admin getAdminById(Long id) {
	         return  adminDao.findById(id)
	                 .orElseThrow(() -> new IllegalArgumentException("Admin not found with id " + id));
	     }

	     public Admin updateAdmin(Long id, Admin adminDetails) {
	         Admin admin =  adminDao.findById(id)
	                 .orElseThrow(() -> new IllegalArgumentException("Admin not found with id " + id));

	         admin.setName(adminDetails.getName());
	         admin.setPassword(adminDetails.getPassword());

	         return  adminDao.save(admin);
	     }

	     public void deleteAdmin(Long id) {
	    	 adminDao.deleteById(id);
	     }
	 }
