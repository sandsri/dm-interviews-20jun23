package com.example.demo.service;

import com.example.demo.entity.InventoryMasterEntity;
import com.example.demo.repo.InventorymasterRepo;
import com.example.demo.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl implements CrudService{
    @Autowired
    InventorymasterRepo inventorymasterRepo;
    @Override
    public CommonResponse getInventoryDetails() {
        CommonResponse response = new CommonResponse();
        response.setData(inventorymasterRepo.findAll());
        response.setStatusCode(200);
        response.setMessage("success");
        return response;
    }
    @Override
    public CommonResponse saveInventoryDetails(InventoryMasterEntity inventoryMasterEntity) {
        CommonResponse response = new CommonResponse();
        response.setData(inventorymasterRepo.save(inventoryMasterEntity));
        response.setStatusCode(200);
        response.setMessage("success");
        return response;
    }
    @Override
    public CommonResponse deleteInventoryDetails(Long id) {
        CommonResponse response = new CommonResponse();
        inventorymasterRepo.deleteById(id);
        response.setStatusCode(200);
        response.setMessage("success");
        return response;
    }
}
