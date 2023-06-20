package com.inventory.api.service;

import com.inventory.api.DTO.Inventory_Master_DTO;
import com.inventory.api.model.Inventory_Master_Ayush;

public interface InventoryService {

    Inventory_Master_Ayush createInventory(Inventory_Master_DTO inventoryDTO);
    Inventory_Master_Ayush updateInventory(Inventory_Master_DTO inventoryDTO);

    Inventory_Master_Ayush getInventory(String inventoryMasterId);
    Inventory_Master_Ayush deleteInventory(String inventoryMasterId);

}