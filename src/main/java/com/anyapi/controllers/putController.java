package com.anyapi.controllers;

import com.anyapi.models.Item;
import com.anyapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to Maintain PUT APIs
 */
@RestController
public class putController {

    @Autowired
    ItemRepository itemRepository;

    @PutMapping("/api/items/{id}")
    public ResponseEntity<Map<String, String>> updateItem(@PathVariable int id, @RequestBody Item updatedItem) {
        // Find the item in the list
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null) {
            // Return 404 if the item does not exist
            return new ResponseEntity<>(Map.of("message", "Item not found"), HttpStatus.NOT_FOUND);
        }

        // Update the existing item's details
        existingItem.setName(updatedItem.getName());
        existingItem.setId(updatedItem.getId());
        // Optionally update other fields as needed

        Map<String, String> response = new HashMap<>();
        response.put("message", "Item updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
