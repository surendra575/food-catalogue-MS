package com.surendra.FoodCatelogue.controller;

import com.surendra.FoodCatelogue.DTO.FoodCateloguePage;
import com.surendra.FoodCatelogue.DTO.FoodItemDTO;
import com.surendra.FoodCatelogue.service.FoodCatelogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatelogue")
@CrossOrigin
public class FoodCatelogueController {
    @Autowired
    public FoodCatelogueService foodCatelogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        System.out.println("In controller: "+foodItemDTO.getItemDescription());
      FoodItemDTO foodItemSaved =  foodCatelogueService.addFoodItem(foodItemDTO);
      return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurentsAndFoodItemsById/{id}")
    public ResponseEntity<FoodCateloguePage> fetchRestaurentsAndFoodItemsById(@PathVariable Integer id){
        FoodCateloguePage foodCateloguePage= foodCatelogueService.fetchFoodCateloguePageDetails(id);
        return new ResponseEntity<>(foodCateloguePage,HttpStatus.OK);
    }
}
