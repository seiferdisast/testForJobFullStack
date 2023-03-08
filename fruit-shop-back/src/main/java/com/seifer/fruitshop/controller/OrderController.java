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

    @Autowired FruitRepo fruitRepo;

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            //TODO Implement Your Logic To Get Data From Service Layer Or Directly From Repository Layer
            return new ResponseEntity<>("GetAll Results", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


/* [
{
"tipo":"manzana",
"cantidad":2
},
{
"tipo":"pera",
"cantidad":5
},
] 
*/

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody List<OrderRequestBody> orderOfFruit) {

        for (OrderRequestBody orderRequestBody : orderOfFruit) {
            String typeFruit = orderRequestBody.getType();
            Fruit fruit = fruitRepo.findByType(typeFruit);
            fruit.setQuantity(fruit.getQuantity() - orderRequestBody.getQuantity());
            fruitRepo.save(fruit);
        }

        return new ResponseEntity<>("orderRepo.save(orderOfFruit)", HttpStatus.OK);
        
        /* try {
            return new ResponseEntity<>(orderRepo.save(orderOfFruit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } */
    }
}
