package com.ts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Admin;


@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
	Admin findByUsernameAndPassword(String username, String password);
    // Add custom query methods here if needed
}

