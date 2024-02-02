package com.ts.controller;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.ts.model.Menu;
import com.ts.service.MenuService;

import java.util.List;

	@RestController
	@RequestMapping("/menu")
	public class MenuController {

	    @Autowired
	    private MenuService menuService;

	    @GetMapping("/all")
	    public ResponseEntity<List<Menu>> getAllMenuItems() {
	        List<Menu> menuItems = menuService.getAllMenuItems();
	        return ResponseEntity.ok(menuItems);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Menu> getMenuItemById(@PathVariable Long id) {
	        Menu menuItem = menuService.getMenuItemById(id);
	        if (menuItem != null) {
	            return ResponseEntity.ok(menuItem);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Void> addMenuItem(@RequestBody Menu menu) {
	        menuService.addMenuItem(menu);
	        return ResponseEntity.ok().build();
	    }

	    @PutMapping("/update")
	    public ResponseEntity<Void> updateMenuItem(@RequestBody Menu menu) {
	        menuService.updateMenuItem(menu);
	        return ResponseEntity.ok().build();
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
	        menuService.deleteMenuItem(id);
	        return ResponseEntity.ok().build();
	    }
	}

