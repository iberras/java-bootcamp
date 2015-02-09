package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value = "/{idUser}/{idItem}/{quantity}", method = RequestMethod.POST)
	ResponseEntity<?> addToCart(@PathVariable int idUser, @PathVariable int idItem, @PathVariable int quantity) {
		shoppingService.addToCart(idUser, idItem, quantity);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{idUser}/{idItem}/{quantity}")
				.buildAndExpand(idUser).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	
	
}