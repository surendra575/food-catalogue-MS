package com.surendra.FoodCatelogue.service;

import com.surendra.FoodCatelogue.DTO.FoodCateloguePage;
import com.surendra.FoodCatelogue.DTO.FoodItemDTO;
import com.surendra.FoodCatelogue.DTO.Restaurent;
import com.surendra.FoodCatelogue.entity.FoodItemEntity;
import com.surendra.FoodCatelogue.mapper.FoodItemMapper;
import com.surendra.FoodCatelogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCatelogueService {
    @Autowired
    FoodItemRepo repo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        System.out.println("In Servive: "+foodItemDTO.getItemDescription());
        FoodItemEntity foodItemEntity = FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItemEntity(foodItemDTO);
        foodItemEntity.setItemDescription(foodItemDTO.getItemDescription());
        System.out.println("After convert : "+foodItemEntity.getItemDescription());
        FoodItemEntity foodItem = repo.save(foodItemEntity);
        System.out.println("After saves : "+foodItem.getItemDescription());
        FoodItemDTO foodItemDTO1 = FoodItemMapper.INSTANCE.mapFoodItemEntityToFoodItemDTO(foodItem);
        foodItemDTO1.setItemDescription(foodItem.getItemDescription());
        return foodItemDTO1;
    }

    public FoodCateloguePage fetchFoodCateloguePageDetails(Integer restaurentId) {
        //fetchFoodCateloguePageDetails is combination of FoodItem and Restaurent details
        List<FoodItemEntity> foodItemList= fetchFoodItemsList(restaurentId);
        Restaurent restaurent= fetchRestaurentDetailsFromRestaurentMS(restaurentId);
        return createFoodCateloguePage(foodItemList, restaurent);
    }

    private FoodCateloguePage createFoodCateloguePage(List<FoodItemEntity> foodItemList, Restaurent restaurent) {
        FoodCateloguePage foodCateloguePage=new FoodCateloguePage();
        foodCateloguePage.setFoodItemsList(foodItemList);
        foodCateloguePage.setRestaurent(restaurent);
        return foodCateloguePage;
    }

    private Restaurent fetchRestaurentDetailsFromRestaurentMS(Integer restaurentId) {
        return restTemplate.getForObject("http://RESTAURENT-SERVICE/restaurent/fetchById/"+restaurentId,Restaurent.class);

    }

    private List<FoodItemEntity> fetchFoodItemsList(Integer restaurentId) {
        return repo.findByRestaurentId(restaurentId);
    }

}
