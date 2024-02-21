package com.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ts.model.Menu;

import com.ts.service.MenuService;

import java.util.List;

@RestController

@RequestMapping("/menu")

public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping
	public List<Menu> getAllMenus() {
		return menuService.getAllMenus();
	}

	@GetMapping("/{id}")
	public Menu getMenuById(@PathVariable Long id) {
		return menuService.getMenuById(id);
	}

	 @PostMapping("/addmenu")
		public ResponseEntity<String>addMenuItem(@RequestParam("name") String name ,@RequestParam("description")String description, @RequestParam("price") double price, @RequestParam("image") MultipartFile image) {
			String product =menuService.addMenuItem(name,description, price, image);
			return ResponseEntity.ok(product);
		}

	@PutMapping("/{id}")
	public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
		return menuService.updateMenu(id, menu);
	}

	@DeleteMapping("/{id}")
	public void deleteMenu(@PathVariable Long id) {
		menuService.deleteMenu(id);
	}
}
