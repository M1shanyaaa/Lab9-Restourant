package com.resrourant.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контролер для обробки основних сторінок веб-додатку.
 */
@Controller
public class MainController {

    /**
     * Обробляє запит на головну сторінку.
     *
     * @param model об'єкт Model для передачі даних у шаблон
     * @return назва шаблону "home"
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Головна сторінка)");
        return "home";
    }

    /**
     * Обробляє запит на сторінку "Про нас".
     *
     * @param model об'єкт Model для передачі даних у шаблон
     * @return назва шаблону "about"
     */
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
