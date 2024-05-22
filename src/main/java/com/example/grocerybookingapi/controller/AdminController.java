package com.example.grocerybookingapi.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocerybookingapi.exception.ExceptionResponse;
import com.example.grocerybookingapi.model.GroceryItem;
import com.example.grocerybookingapi.service.GroceryItemService;
 
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private GroceryItemService groceryItemService;
 
    @GetMapping("/getAll/items")
    public ResponseEntity<List<GroceryItem>> getAllItems() {
         List<GroceryItem> allItems = groceryItemService.getAllItems();
         return new ResponseEntity<>(allItems, HttpStatus.OK);

    }
 
	@PostMapping("/save/items")
	public ResponseEntity<GroceryItem> addItem(@RequestBody GroceryItem item) {

		GroceryItem addItem = groceryItemService.addItem(item);
		return new ResponseEntity<>(addItem, HttpStatus.CREATED);
	}

	@PutMapping("/update/items/{id}")
	public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
		try {
		GroceryItem addItem = groceryItemService.addItem(item);
		return new ResponseEntity<>(addItem, HttpStatus.CREATED);
		}catch (ExceptionResponse er) {
			ExceptionResponse ce = new ExceptionResponse(er.getErrorCode(), er.getErrorMessage());
			return new ResponseEntity<ExceptionResponse>(ce,HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ExceptionResponse ce = new ExceptionResponse("400", "something wrong");
			return new ResponseEntity<ExceptionResponse>(ce, HttpStatus.BAD_REQUEST);

		}
	}

    @DeleteMapping("/delete/items/{id}")
    public ResponseEntity<GroceryItem> deleteItem(@PathVariable Long id) {
    	
        if (!groceryItemService.getItemById(id).isEmpty()) {
            groceryItemService.deleteItem(id);
    		return new ResponseEntity<>(HttpStatus.ACCEPTED);
       
    }
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
}
    }