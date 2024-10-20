package com.anyapi.controllers;

import com.anyapi.models.Item;
import com.anyapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
/**
 * Class to Maintain POST APIs
 */
public class postController {

    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/api/createItem")
    public ResponseEntity<Map<String, String>> createItem(@RequestBody Item item) {
        // Check if the item already exists by ID
        Optional<Item> existingItem = itemRepository.findById(item.getId());

        if (existingItem.isPresent()) {
            return new ResponseEntity<>(Map.of("message", "Item already exists"), HttpStatus.CONFLICT);
        }
        itemRepository.save(item);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Item created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
