package com.resrourant.service.controllers;

import com.resrourant.service.models.Menu;
import com.resrourant.service.repo.MenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuAndPricingController {

    private final MenuRepository menuRepository;

    public MenuAndPricingController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menupricing")
    public String menuPricing(Model model) {
        model.addAttribute("menuItems", menuRepository.findAll()); // Додати дані для відображення
        return "menupricing";  // Назва Thymeleaf шаблону
    }

    @PostMapping("/menupricing")
    public String menuPostAdd(@RequestParam String dish, @RequestParam String price, @RequestParam String readiness) {
        Menu menu = new Menu(dish, price, readiness);
        menuRepository.save(menu);
        return "/menupricing";
    }
}
