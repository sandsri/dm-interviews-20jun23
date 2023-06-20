package com.example.demo.repo;

import com.example.demo.entity.InventoryMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InventorymasterRepo extends JpaRepository<InventoryMasterEntity, Long> {
}
