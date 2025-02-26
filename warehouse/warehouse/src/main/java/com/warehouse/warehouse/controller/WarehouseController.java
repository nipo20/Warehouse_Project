package com.warehouse.warehouse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @GetMapping("/")
    public ResponseEntity<?> wareHouseHealth(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/wareHouse")
    public ResponseEntity<?> wareHouse_inventoryHealth(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
