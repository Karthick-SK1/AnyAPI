package com.anyapi.controllers;

import com.anyapi.models.Item;
import com.anyapi.repositories.ItemRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class to Maintain GET APIs
 */
@RestController
public class getController {

    private static final Logger log = LoggerFactory.getLogger(getController.class);

    @Autowired
    private ItemRepository itemRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/api/items")
    public ResponseEntity<List<Item>> getItems() throws JsonProcessingException {
        List<Item> items = itemRepository.findAll(); // Fetch all items from the repository
        String response = objectMapper.writeValueAsString(items);
        log.info("Fetching all items: {}", response); // Log the items
        return ResponseEntity.ok(items); // Return the list of items
    }
}