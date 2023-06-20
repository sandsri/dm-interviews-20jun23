package com.inventory.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Table(name = "inventory_master_ayush")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory_Master_Ayush {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "productName", columnDefinition = "VARCHAR(36)")
    private String productName;

    @Column(name = "productDescription", columnDefinition = "VARCHAR(36)")
    private String productDescription;

    @Column(name = "price_per_unit", columnDefinition = "double")
    private double pricePerUnit;



}
