package com.example.demo.service;

import com.example.demo.entity.InventoryMasterEntity;
import com.example.demo.response.CommonResponse;

public interface CrudService {
    CommonResponse getInventoryDetails();
    CommonResponse saveInventoryDetails(InventoryMasterEntity inventoryMasterEntity);

    CommonResponse deleteInventoryDetails(Long id);
}
