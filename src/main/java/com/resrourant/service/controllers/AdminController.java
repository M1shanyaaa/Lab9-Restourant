package com.resrourant.service.controllers;

import com.resrourant.service.models.Menu;
import com.resrourant.service.repo.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контролер для управління адміністративними функціями, такими як
 * відображення та зміна стану готовності замовлень.
 */
@Controller
public class AdminController {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * Відображає адміністративну панель.
     *
     * @param model об'єкт Model для передачі даних у шаблон
     * @return назва шаблону "admin"
     */
    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    /**
     * Відображає сторінку для маніпуляції замовленнями.
     *
     * @param model об'єкт Model для передачі списку страв у шаблон
     * @return назва шаблону "manipulateorder"
     */
    @GetMapping("/manipulateorder")
    public String manipulateorder(Model model) {
        Iterable<Menu> menu_items = menuRepository.findAll();
        model.addAttribute("menu_items", menu_items);
        return "manipulateorder";
    }

    /**
     * Оновлює стан готовності для конкретного пункту меню.
     *
     * @param id        ідентифікатор пункту меню
     * @param readiness новий стан готовності (наприклад, "Готово" чи "У обробці")
     * @return перенаправлення на сторінку "manipulateorder"
     * @throws IllegalArgumentException якщо пункт меню з переданим ідентифікатором не знайдено
     */
    @PostMapping("/manipulateorder")
    public String updateReadiness(@RequestParam Long id, @RequestParam String readiness) {
        Menu menuItem = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu ID: " + id));
        menuItem.setReadiness(readiness);
        menuRepository.save(menuItem);
        return "redirect:/manipulateorder";
    }
}
