package com.sap.inventory.service;

import com.sap.inventory.entity.Inventory;
import com.sap.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getInventoryById(Long productId) {
        return inventoryRepository.findById(productId).orElse(null);
    }

    public List<Inventory> createInventory(List<Inventory> inventory) {
        return inventoryRepository.saveAll(inventory);
    }

    public Inventory updateInventory(Long productId, Inventory updatedInventory) {
        Inventory existingInventory = inventoryRepository.findById(productId).orElse(null);
        if (existingInventory != null) {
            existingInventory.setProductName(updatedInventory.getProductName());
            existingInventory.setQuantity(updatedInventory.getQuantity());
            existingInventory.setPrice(updatedInventory.getPrice());
            return inventoryRepository.save(existingInventory);
        }
        return null;
    }

    public boolean deleteInventory(Long productId) {
        if (inventoryRepository.existsById(productId)) {
            inventoryRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}