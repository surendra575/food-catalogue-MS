package com.surendra.FoodCatelogue.repo;

import com.surendra.FoodCatelogue.entity.FoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItemEntity, Integer> {
    public List<FoodItemEntity> findByRestaurentId(Integer restaurentId);
}
