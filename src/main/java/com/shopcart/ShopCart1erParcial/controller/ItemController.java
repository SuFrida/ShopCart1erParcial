package com.shopcart.ShopCart1erParcial.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopcart.ShopCart1erParcial.entity.Item;
import com.shopcart.ShopCart1erParcial.repository.ItemRepository;

@Controller
@RequestMapping("/items/")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("CartItems", Arrays.asList(
                new CartItems("Product 1", "This is the first product", 25, 1),
                new CartItems("Product 2", "This is the second product", 35, 2),
                new CartItems("Product 3", "This is the third product", 20, 3),
                new CartItems("Product 4", "This is the forth product", 11, 4),
                new CartItems("Product 5", "This is the fifth product", 11, 5)));
        return "cart";
    }

    @GetMapping("new-product")
    public String showSignUpForm(Item item) {
        return "add-item";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addItem(Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-item";
        }

        itemRepository.save(item);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        model.addAttribute("item", item);
        return "update-item";
    }

    @PostMapping("update/{id}")
    public String updateItem(@PathVariable("id") long id, Item item, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            item.setId(id);
            return "update-item";
        }

        itemRepository.save(item);
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteItem(@PathVariable("id") long id, Model model) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        itemRepository.delete(item);
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }
}
