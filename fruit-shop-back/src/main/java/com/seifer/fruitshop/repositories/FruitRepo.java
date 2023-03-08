package com.seifer.fruitshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seifer.fruitshop.model.Fruit;

@Repository
public interface FruitRepo extends JpaRepository<Fruit, Long> {
    //Fruit findByType(String type);
}
