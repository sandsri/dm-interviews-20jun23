package com.interview.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.bean.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
}

