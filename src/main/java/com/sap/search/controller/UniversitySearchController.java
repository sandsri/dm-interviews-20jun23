package com.sap.search.controller;

import com.sap.search.service.UniversityService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@Validated
@Slf4j
public class UniversitySearchController {

    private final UniversityService universityService;

    @Autowired
    public UniversitySearchController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public ResponseEntity<Object> searchProducts(
            @RequestParam(name = "name") @Valid String name) {
        log.debug("Searching for name: {}", name);
        return ResponseEntity.ok(universityService.searchUniversitiesByName(name));
    }
}