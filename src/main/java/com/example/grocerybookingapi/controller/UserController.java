package com.example.grocerybookingapi.controller;
 
import com.example.grocerybookingapi.model.GroceryItem;
import com.example.grocerybookingapi.model.Order;
import com.example.grocerybookingapi.service.GroceryItemService;
import com.example.grocerybookingapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GroceryItemService groceryItemService;
    
    @Autowired
    private OrderService orderService;
 
    @GetMapping("/get/items")
    public List<GroceryItem> getAllItems() {
        return groceryItemService.getAllItems();
    }
 
    @PostMapping("/save/order")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }
}