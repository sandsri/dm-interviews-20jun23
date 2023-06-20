package com.example.demo.controller;

import com.example.demo.entity.InventoryMasterEntity;
import com.example.demo.response.CommonResponse;
import com.example.demo.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RequestMapping("/api/inventory")
@RestController
public class CrudController {
    @Autowired
    CrudService crudService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getInventoryDetails() {
        return crudService.getInventoryDetails();
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveInventoryDetails(@RequestBody InventoryMasterEntity inventoryMasterEntity) {
        return crudService.saveInventoryDetails(inventoryMasterEntity);
    }

    @GetMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteInventoryDetails(@RequestParam Long id) {
        return crudService.deleteInventoryDetails(id);
    }

}
