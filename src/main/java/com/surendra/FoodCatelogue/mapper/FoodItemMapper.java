package com.surendra.FoodCatelogue.mapper;

import com.surendra.FoodCatelogue.DTO.FoodItemDTO;
import com.surendra.FoodCatelogue.entity.FoodItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);

    FoodItemEntity mapFoodItemDTOToFoodItemEntity(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemEntityToFoodItemDTO(FoodItemEntity foodItemEntity);

}
