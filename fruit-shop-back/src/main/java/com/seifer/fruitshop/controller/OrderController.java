package com.seifer.fruitshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seifer.fruitshop.model.Fruit;
import com.seifer.fruitshop.model.Order;
import com.seifer.fruitshop.model.OrderRequestBody;
import com.seifer.fruitshop.repositories.OrderRepo;
import com.seifer.fruitshop.repositories.FruitRepo;

@RestController
@RequestMapping("/ordercontroller")
public class OrderController {

    @Autowired
    FruitRepo fruitRepo;

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping()
    public List<Order> getAllFruits() {
        return orderRepo.findAll();
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody List<OrderRequestBody> orderOfFruit) {

        Double total = 0.0;

        for (OrderRequestBody orderRequestBody : orderOfFruit) {
            String typeFruit = orderRequestBody.getType();
            Fruit fruit = fruitRepo.findByType(typeFruit);
            if (fruit == null) {
                return new ResponseEntity<>("Not fruit found", HttpStatus.BAD_REQUEST);
            }
            if (fruit.getQuantity() < orderRequestBody.getQuantity()) {
                return new ResponseEntity<>("Not enough quantity", HttpStatus.BAD_REQUEST);
            }
            Double pricePerUnit = fruit.getPrice();
            total += pricePerUnit * orderRequestBody.getQuantity();
            fruit.setQuantity(fruit.getQuantity() - orderRequestBody.getQuantity());
            fruitRepo.save(fruit);
        }

        if (orderOfFruit.size() > 4) {
            Double discount = 0.10 * total;
            total -= discount;
        }

        Order order = new Order();
            order.setFruitList(orderOfFruit.toString());
            order.setFullValue(total);
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
    }
}
