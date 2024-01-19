package com.surendra.FoodCatelogue.DTO;

import com.surendra.FoodCatelogue.entity.FoodItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCateloguePage {
    private List<FoodItemEntity> foodItemsList;
    private Restaurent restaurent;
}
