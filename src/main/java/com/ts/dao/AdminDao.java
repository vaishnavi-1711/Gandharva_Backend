package com.ts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Admin;

import java.util.List;
@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {

	
}

