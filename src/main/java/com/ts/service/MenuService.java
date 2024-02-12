package com.ts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.MenuDao;
import com.ts.exception.MenuNotFoundException;
import com.ts.model.Menu;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public List<Menu> getAllMenuItems() {
        return menuDao.findAll();
    }

    public Menu getMenuItemById(Long id) {
    	 return menuDao.findById(id).orElseThrow(() -> new MenuNotFoundException("Menu item not found with ID: " + id));
    	 
    }

    public List<Menu> getMenuItemsByCategory(String category) {
        return menuDao.findByCategory(category);
    }

    public List<Menu> getMenuItemsByPriceLessThan(double price) {
        return menuDao.findByPriceLessThan(price);
    }

    public void addMenuItem(Menu menu) {
        menuDao.save(menu);
    }

    public void updateMenuItem(Menu menu) {
        if (menuDao.existsById(menu.getId())) {
            menuDao.save(menu);
        }
        else {
            throw new MenuNotFoundException("Menu item not found with ID: " + menu.getId());
        }
    }

    public void deleteMenuItem(Long id) {
        menuDao.deleteById(id);
        if (menuDao.existsById(id)) {
            menuDao.deleteById(id);
        } else {
            throw new MenuNotFoundException("Menu item not found with ID: " + id);
        }
}
}
