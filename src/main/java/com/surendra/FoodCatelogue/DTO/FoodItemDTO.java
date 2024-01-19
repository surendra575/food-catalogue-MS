package com.surendra.FoodCatelogue.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    public Integer id;
    public String itemName;
    private String itemDescription;
    public boolean isVeg;
    public Number price;
    public Integer restaurentId;
    public Integer Quantity;
}
