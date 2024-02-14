package com.ts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ts.model.Menu;

import com.ts.service.MenuService;

import java.io.IOException;
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

	    @PostMapping("/items")
	    public ResponseEntity<Menu> addMenuItem(@RequestParam("item_name") String itemName,
	                                                @RequestParam("category") String category,
	                                                @RequestParam("price") double price,
	                                                @RequestParam("file") MultipartFile file) {
	        try {
	            byte[] fileData = file.getBytes();
	            Menu menuItem = new Menu();
	            menuItem.setItem_name(itemName);
	            menuItem.setCategory(category);
	            menuItem.setPrice(price);
	            menuItem.setFileData(fileData);
	            Menu savedMenuItem = new Menu();
	            return ResponseEntity.status(HttpStatus.CREATED).body(savedMenuItem);
	        } catch (IOException e) {
	            e.printStackTrace(); // Handle the exception appropriately
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
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

