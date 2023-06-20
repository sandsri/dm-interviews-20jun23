package com.sap.inventory.controller;

import com.sap.inventory.entity.Inventory;
import com.sap.inventory.service.InventoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventory(@PathVariable @NotNull Long productId) {
        Inventory inventory = inventoryService.getInventoryById(productId);
        if (inventory != null) {
            return ResponseEntity.ok(inventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<List<Inventory>> createInventory(@Valid @RequestBody @NotNull List<Inventory> inventory) {
        List<Inventory> createdInventory = inventoryService.createInventory(inventory);
        return ResponseEntity.status(CREATED).body(createdInventory);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable @NotNull Long productId, @RequestBody Inventory inventory) {
        Inventory updatedInventory = inventoryService.updateInventory(productId, inventory);
        if (updatedInventory != null) {
            return ResponseEntity.ok(updatedInventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteInventory(@PathVariable @NotNull Long productId) {
        boolean deleted = inventoryService.deleteInventory(productId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}