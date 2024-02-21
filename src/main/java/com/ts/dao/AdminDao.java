package com.ts.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {

	Optional<Admin> findByUsername(String username);
   
}
