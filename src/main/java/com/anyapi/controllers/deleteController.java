package com.anyapi.controllers;

import com.anyapi.models.Item;
import com.anyapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to Maintain DELETE Requests
 */
@RestController
public class deleteController {

    @Autowired
    ItemRepository itemRepository;
    Map<String, String> response = new HashMap<>();

    @DeleteMapping("api/items/{id}")
    public ResponseEntity<Map<String, Object>> deleteItem(@PathVariable int id){
        itemRepository.deleteById(id);
        response.put("message", "Succesfully Deleted " + id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
