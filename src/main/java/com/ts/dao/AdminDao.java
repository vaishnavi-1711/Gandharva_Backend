package com.ts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Admin;

import java.util.List;
@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {

    Admin findByUsername(String username);

    List<Admin> findByRole(String role);

    List<Admin> findByRoleOrderByUsernameAsc(String role);

    long countByRole(String role);

    List<Admin> findByRoleAndUsernameContaining(String role, String username);

    List<Admin> findByRoleIn(List<String> roles);
}
