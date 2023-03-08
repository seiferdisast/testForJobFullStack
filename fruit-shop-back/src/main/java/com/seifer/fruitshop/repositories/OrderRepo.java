package com.seifer.fruitshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seifer.fruitshop.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
