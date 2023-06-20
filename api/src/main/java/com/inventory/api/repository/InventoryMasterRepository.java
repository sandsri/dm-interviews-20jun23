package com.inventory.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.inventory.api.model.Inventory_Master_Ayush;
@Repository
public interface InventoryMasterRepository extends CrudRepository<Inventory_Master_Ayush,String> {
}
