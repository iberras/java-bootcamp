package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entities.Item;

@RestController
@RequestMapping("/shopping")
public class ShoppingCartRestController {

	@Autowired
	private final UserService userService;
	
	@Autowired
	private final ShoppingService shoppingService;
	
	@Autowired
	ShoppingCartRestController(UserService userService, ShoppingService shoppingService) {
		this.userService = userService;
		this.shoppingService = shoppingService;
	}
	
	@RequestMapping(value = "/{idUser}/{idItem}/{quantity}", method = RequestMethod.PUT)
	ResponseEntity<?> addToCart(@PathVariable int idUser, @PathVariable int idItem, @PathVariable int quantity) {
		shoppingService.addToCart(idUser, idItem, quantity);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{idUser}/{idItem}/{quantity}")
				.buildAndExpand(idUser).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{idUser}/{idItem}/{quantity}", method = RequestMethod.POST)
	ResponseEntity<?> updateItemFromCart(@PathVariable int idUser, @PathVariable int idItem, @PathVariable int quantity) {
		shoppingService.updateItemFromCart(idUser, idItem, quantity);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{idUser}/{idItem}/{quantity}")
				.buildAndExpand(idUser).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{idUser}/", method = RequestMethod.DELETE)
	public void clearCart(@PathVariable int idUser){
		shoppingService.clearCart(idUser);
	}

	@RequestMapping(value = "/{idUser}/{idItem}", method = RequestMethod.DELETE)
	public void clearCart(@PathVariable int idUser, @PathVariable int idItem){
		shoppingService.deleteFromCart(idUser, idItem);
	}
	
	@RequestMapping(value = "/{idUser}/", method = RequestMethod.GET)
	public void checkOut(@PathVariable int idUser) {
		shoppingService.checkOut(idUser);
	}
	
	@RequestMapping(value = "/{nameCategory}/", method = RequestMethod.GET)
	public List<Item> getProductsByCategory(@PathVariable String nameCategory) {
		return shoppingService.getProductsByCategory(nameCategory);
	}
	
	@RequestMapping(value = "/{nameItem}/", method = RequestMethod.GET)
	public List<Item> getProductsByName(@PathVariable String nameItem) {
		return shoppingService.getProductsByName(nameItem);
	}
	
}