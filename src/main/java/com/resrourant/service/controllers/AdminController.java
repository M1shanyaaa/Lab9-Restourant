package com.resrourant.service.controllers;

import com.resrourant.service.models.Menu;
import com.resrourant.service.repo.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/manipulateorder")
    public String manipulateorder(Model model) {
        Iterable<Menu> menu_items = menuRepository.findAll();
        model.addAttribute("menu_items", menu_items);
        return "manipulateorder";
    }

    @PostMapping("/manipulateorder")
    public String updateReadiness(@RequestParam Long id, @RequestParam String readiness) {
        Menu menuItem = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu ID: " + id));
        menuItem.setReadiness(readiness);
        menuRepository.save(menuItem);
        return "redirect:/manipulateorder";
    }
}
