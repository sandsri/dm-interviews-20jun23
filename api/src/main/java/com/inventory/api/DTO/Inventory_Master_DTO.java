package com.inventory.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory_Master_DTO {
    private String id;
    private String productName;
    private String productDescription;
    private String pricePerUnit;


}

