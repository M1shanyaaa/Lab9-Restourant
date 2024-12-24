package com.resrourant.service.controllers;

import com.resrourant.service.models.Menu;
import com.resrourant.service.repo.MenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller responsible for managing the menu and pricing operations.
 * Handles displaying the menu and adding new dishes with pricing.
 */
@Controller
public class MenuAndPricingController {

    private final MenuRepository menuRepository;

    /**
     * Constructor for MenuAndPricingController.
     *
     * @param menuRepository the MenuRepository instance to interact with the menu data
     */
    public MenuAndPricingController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /**
     * Displays the menu with pricing information.
     * Fetches all menu items from the repository and adds them to the model to be rendered on the page.
     *
     * @param model the Model object used to pass data to the view
     * @return the name of the Thymeleaf template to render (menupricing)
     */
    @GetMapping("/menupricing")
    public String menuPricing(Model model) {
        model.addAttribute("menuItems", menuRepository.findAll()); // Add menu items to model
        return "menupricing";  // Return the name of the Thymeleaf template to render
    }

    /**
     * Handles the submission of a new menu item along with its price and readiness.
     * This method adds the new dish to the menu repository and refreshes the page.
     *
     * @param dish the name of the dish to add to the menu
     * @param price the price of the dish
     * @param readiness the readiness state of the dish (e.g., "Available" or "Not Available")
     * @return the name of the Thymeleaf template to render (menupricing)
     */
    @PostMapping("/menupricing")
    public String menuPostAdd(@RequestParam String dish, @RequestParam String price, @RequestParam String readiness) {
        Menu menu = new Menu(dish, price, readiness); // Create a new menu item
        menuRepository.save(menu); // Save the menu item to the repository
        return "/menupricing"; // Return to the menupricing view
    }
}
