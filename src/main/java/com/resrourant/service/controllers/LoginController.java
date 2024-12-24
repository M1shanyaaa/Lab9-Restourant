package com.resrourant.service.controllers;

import com.resrourant.service.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

/**
 * Контролер для управління процесом авторизації користувачів.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    /**
     * Відображає сторінку авторизації.
     *
     * @return назва шаблону "login"
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * Обробляє спробу входу користувача.
     *
     * @param name     ім'я користувача (логін)
     * @param password пароль користувача
     * @param model    об'єкт Model для передачі повідомлень у шаблон
     * @return перенаправлення на відповідну сторінку залежно від ролі користувача
     * або повернення на сторінку входу в разі невірних даних
     */
    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, Model model) {
        if (Objects.equals(name, "admin") && Objects.equals(password, "admin")) {
            // Перенаправлення на адміністративну панель для адміністратора
            return "redirect:/admin";
        } else if (Objects.equals(name, "user") && Objects.equals(password, "user")) {
            // Перенаправлення на головну сторінку для звичайного користувача
            return "redirect:/";
        } else {
            // Додавання повідомлення про помилку в модель та повернення на сторінку авторизації
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
