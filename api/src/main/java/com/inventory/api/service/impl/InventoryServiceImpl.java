package com.inventory.api.service.impl;

import com.inventory.api.DTO.Inventory_Master_DTO;
import com.inventory.api.model.Inventory_Master_Ayush;
import com.inventory.api.repository.InventoryMasterRepository;
import com.inventory.api.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryMasterRepository inventoryMasterRepository;
    @Override
    public Inventory_Master_Ayush createInventory(Inventory_Master_DTO inventoryDTO) {
        Inventory_Master_Ayush inventory = new Inventory_Master_Ayush();
        try {
            inventory.setProductName(inventoryDTO.getProductName());
            inventory.setProductDescription(inventoryDTO.getProductDescription());
            inventory.setPricePerUnit(Double.parseDouble(inventoryDTO.getPricePerUnit()));
            inventoryMasterRepository.save(inventory);
        }catch(Exception e){

            inventory=null;
        }
        return inventory;
    }

    @Override
    public Inventory_Master_Ayush updateInventory(Inventory_Master_DTO inventoryDTO) {
        Optional<Inventory_Master_Ayush> inventory = inventoryMasterRepository.findById(inventoryDTO.getId());
        if(inventory.isPresent()) {
            try {

                inventory.get().setProductName(inventoryDTO.getProductName());
                inventory.get().setProductDescription(inventoryDTO.getProductDescription());
                inventory.get().setPricePerUnit(Double.parseDouble(inventoryDTO.getPricePerUnit()));
                inventoryMasterRepository.save(inventory.get());
            } catch (Exception e) {

                inventory = null;
            }
        }else{
            inventory=null;
        }
        return inventory.get();
    }

    @Override
    public Inventory_Master_Ayush getInventory(String inventoryMasterId) {
        if(inventoryMasterId!=null && !inventoryMasterId.equals("")){
            Optional<Inventory_Master_Ayush> inventory = inventoryMasterRepository.findById(inventoryMasterId);
            if(inventory.isPresent()){
                return inventory.get();
            }else {
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public Inventory_Master_Ayush deleteInventory(String inventoryMasterId) {
        if(inventoryMasterId!=null && !inventoryMasterId.equals("")){
            Optional<Inventory_Master_Ayush> inventory = inventoryMasterRepository.findById(inventoryMasterId);
            if(inventory.isPresent()){
                Inventory_Master_Ayush inventoryMasterAyush=  inventory.get();
                inventoryMasterRepository.deleteById(inventoryMasterId);
                return inventoryMasterAyush;
            }else {
                return null;
            }
        }else{
            return null;
        }
    }
}
