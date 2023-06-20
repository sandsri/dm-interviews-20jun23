package com.inventory.api.controller;

import com.inventory.api.model.Inventory_Master_Ayush;
import com.inventory.api.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.inventory.api.DTO.Inventory_Master_DTO;
import org.springframework.http.HttpStatus;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping(value = "/createInventory")
    public ResponseEntity<Inventory_Master_Ayush> create(@RequestBody Inventory_Master_DTO inventoryDTO){
        try {
            Inventory_Master_Ayush savedInventory= inventoryService.createInventory(inventoryDTO);
            return ResponseEntity.status(HttpStatus.OK).body(savedInventory);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping(value = "/updateInventory")
    public ResponseEntity<Inventory_Master_Ayush> update(@RequestBody Inventory_Master_DTO inventoryDTO){
        try {
            Inventory_Master_Ayush savedInventory= inventoryService.updateInventory(inventoryDTO);
            return ResponseEntity.status(HttpStatus.OK).body(savedInventory);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping(value="/getInventoryDetails")
    public ResponseEntity<Inventory_Master_Ayush> getInventoryDetails(String inventoryMasterId){
        try {
            Inventory_Master_Ayush savedInventory= inventoryService.getInventory(inventoryMasterId);
            return ResponseEntity.status(HttpStatus.OK).body(savedInventory);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping(value="/deleteInventory")
    public ResponseEntity<Inventory_Master_Ayush> deleteInventory(String inventoryMasterId){
        try {
            Inventory_Master_Ayush savedInventory= inventoryService.deleteInventory(inventoryMasterId);
            return ResponseEntity.status(HttpStatus.OK).body(savedInventory);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
