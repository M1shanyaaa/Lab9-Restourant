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
 * Controller for handling orders in the restaurant service.
 * Provides functionality to display the menu and delete orders.
 */
@Controller
public class OrdersController {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * Displays the menu with all available items.
     * Fetches all menu items from the database and adds them to the model.
     *
     * @param model the Model object used to pass data to the view
     * @return the name of the HTML view to render (order)
     */
    @GetMapping("/order")
    public String order(Model model) {
        Iterable<Menu> menu_items = menuRepository.findAll();
        model.addAttribute("menu_items", menu_items);
        return "order";
    }

    /**
     * Deletes a menu item by its ID.
     * This method is triggered when a request to delete a specific order/item is made.
     *
     * @param id the ID of the menu item to be deleted
     * @return a redirect to the /order endpoint to refresh the list of menu items
     */
    @PostMapping("/order/delete")
    public String deleteOrder(@RequestParam Long id) {
        menuRepository.deleteById(id); // Deletes the item by its ID
        return "redirect:/order";
    }
}
