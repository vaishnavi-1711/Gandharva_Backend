package com.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.model.Menu;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

import com.ts.dao.MenuDao;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;

	
	public List<Menu> getAllMenus() {
		return menuDao.findAll();
	}

	public Menu getMenuById(Long id) {
		return menuDao.findById(id).orElseThrow(() -> new NoSuchElementException("Menu not found"));
	}

	public String addMenuItem(String name, String description, double price, MultipartFile image) {
		Menu menu = new Menu();
		menu.setName(name);
		menu.setPrice(price);
		menu.setDescription(description);

		try {
			menu.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		menuDao.save(menu);
		return " product has been added succssfully";
	}

	public Menu updateMenu(Long id, Menu updatedMenu) {
		getMenuById(id); // Check if menu exists
		updatedMenu.setId(id); // Ensure the ID is set
		return menuDao.save(updatedMenu);
	}

	public void deleteMenu(Long id) {
		Menu existingMenu = getMenuById(id); // Check if menu exists
		menuDao.delete(existingMenu);
	}

}
