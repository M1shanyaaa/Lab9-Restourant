package com.resrourant.service.controllers;

import com.resrourant.service.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, Model model) {
        if (Objects.equals(name, "admin") && Objects.equals(password, "admin")) {
            return "redirect:/admin";
        } else if (Objects.equals(name, "user") && Objects.equals(password, "user")) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Повертаємо на сторінку входу з повідомленням про помилку
        }
    }

}
