package com.ts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Customer;

import java.util.List;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    List<Customer> findByName(String name);

    Customer findByEmail(String email);

 
    List<Customer> findByNoOfPeopleGreaterThan(int value);
}
