package com.foodTracker.controllers;

import com.foodTracker.Type;
import com.foodTracker.model.Item;
import com.foodTracker.model.User;
import com.foodTracker.repository.ItemRepository;
import com.foodTracker.repository.UserRepository;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public ItemController(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    // Get all items in pantry
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Add a new item with name, quantity, type, and purchase date
    @PostMapping("/add")
    public Item addItem(
            @RequestParam String name,
            @RequestParam String quantity,
            @RequestParam Type type,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate purchaseDate) {

        Item newItem = new Item();
        newItem.setName(name);
        newItem.setQuantity(quantity);
        newItem.setType(type);
        newItem.setLastBought(purchaseDate);

        return itemRepository.save(newItem);
    }

    // Save item with a default user (e.g., from a frontend barcode scanner)
    @PostMapping
    public ResponseEntity<?> saveItem(@RequestBody Item item) {
        try {
            User defaultUser = userRepository.findById(1L).orElse(null);
            if (defaultUser == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Default user not found");
            }

            item.setUser(defaultUser);
            itemRepository.save(item);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace(); // should now show in terminal
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error saving item: " + e.getMessage());
    }
}

    // Delete an item by ID
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

    // Get a single item by ID
    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
