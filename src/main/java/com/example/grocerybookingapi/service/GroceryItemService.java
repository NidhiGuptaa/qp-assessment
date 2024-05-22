package com.example.grocerybookingapi.service;
 
import com.example.grocerybookingapi.model.GroceryItem;
import com.example.grocerybookingapi.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class GroceryItemService {
	@Autowired
	private GroceryItemRepository groceryItemRepository;

	public List<GroceryItem> getAllItems() {
		return groceryItemRepository.findAll();
	}

	public Optional<GroceryItem> getItemById(Long id) {
		return groceryItemRepository.findById(id);
	}

	public GroceryItem addItem(GroceryItem item) {
		return groceryItemRepository.save(item);
	}

	public void deleteItem(Long id) {
		groceryItemRepository.deleteById(id);
	}
}
 