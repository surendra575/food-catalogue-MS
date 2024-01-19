package com.surendra.FoodCatelogue.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurent {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String restaurentDescription;
}
