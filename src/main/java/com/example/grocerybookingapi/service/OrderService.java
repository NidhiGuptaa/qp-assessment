package com.example.grocerybookingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocerybookingapi.model.GroceryItem;
import com.example.grocerybookingapi.model.Order;
import com.example.grocerybookingapi.repository.GroceryItemRepository;
import com.example.grocerybookingapi.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	@Autowired
	private GroceryItem groceryItem;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	@Transactional
	public Order placeOrder(Order order) {
    	int item = groceryItem.getGroceryQuantity();
    	item--;
    	groceryItem.setGroceryQuantity(item);
        groceryItemRepository.save(groceryItem);
		return orderRepository.save(order);
	}
}
