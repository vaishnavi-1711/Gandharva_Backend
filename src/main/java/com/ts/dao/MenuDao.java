package com.ts.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ts.model.Menu;

import java.util.List;
import java.util.Optional;
@Repository


public interface MenuDao extends JpaRepository<Menu, Long> {

	 Optional<Menu> findById(Long id);

    List<Menu> findByNameContainingIgnoreCase(@Param("name")String name);
   

}
