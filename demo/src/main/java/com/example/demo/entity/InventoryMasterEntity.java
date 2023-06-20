package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name= "inventory_master_suganya")
@Entity
public class InventoryMasterEntity implements Serializable {
    @Id
    @GeneratedValue
    Long id;
    String productName;
    String productDesc;
    Double pricePerUnit;

}