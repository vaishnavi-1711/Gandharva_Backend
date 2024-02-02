package com.ts.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Menu;

import java.util.List;
@Repository


public interface MenuDao extends JpaRepository<Menu, Long> {

    List<Menu> findByCategory(String category);

    List<Menu> findByPriceLessThan(double price);
}
