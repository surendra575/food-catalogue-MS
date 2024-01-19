package com.surendra.FoodCatelogue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="fooditem")
public class FoodItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String itemName;
    private String itemDescription;
    public boolean isVeg;
    public Number price;
    public Integer restaurentId;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    public Integer Quantity;

}
