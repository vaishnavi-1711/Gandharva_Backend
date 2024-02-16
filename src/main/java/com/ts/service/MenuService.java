package com.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ts.model.Menu;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import com.ts.dao.MenuDao;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;

	@Value("${upload.path}")
	private String uploadPath; // Path to the folder where images will be saved

	public List<Menu> getAllMenus() {
		return menuDao.findAll();
	}

	public Menu getMenuById(Long id) {
		return menuDao.findById(id).orElseThrow(() -> new NoSuchElementException("Menu not found"));
	}

	public Menu createMenu(Menu menu) {
		return menuDao.save(menu);
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

	public String saveImage(MultipartFile image) throws IOException {
		Path directory = Paths.get(uploadPath);

		if (!Files.exists(directory)) {
			Files.createDirectories(directory);
		}

		String fileName = image.getOriginalFilename();
		Path filePath = directory.resolve(fileName);
		Files.copy(image.getInputStream(), filePath);

		return fileName;
	}
}
