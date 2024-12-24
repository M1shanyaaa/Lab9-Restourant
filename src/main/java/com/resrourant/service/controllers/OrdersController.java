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
public class OrdersController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/order")
    public String order(Model model) {
        Iterable<Menu> menu_items = menuRepository.findAll();
        model.addAttribute("menu_items", menu_items);
        return "order";
    }

    @PostMapping("/order/delete")
    public String deleteOrder(@RequestParam Long id) {
        menuRepository.deleteById(id); // Видаляє елемент за його ID
        return "redirect:/order";
    }
}
