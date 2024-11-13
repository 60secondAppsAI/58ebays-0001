package com.58ebays.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.58ebays.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.58ebays.domain.ShoppingCartItem;
import com.58ebays.dto.ShoppingCartItemDTO;
import com.58ebays.dto.ShoppingCartItemSearchDTO;
import com.58ebays.dto.ShoppingCartItemPageDTO;
import com.58ebays.service.ShoppingCartItemService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/shoppingCartItem")
@RestController
public class ShoppingCartItemController {

	private final static Logger logger = LoggerFactory.getLogger(ShoppingCartItemController.class);

	@Autowired
	ShoppingCartItemService shoppingCartItemService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<ShoppingCartItem> getAll() {

		List<ShoppingCartItem> shoppingCartItems = shoppingCartItemService.findAll();
		
		return shoppingCartItems;	
	}

	@GetMapping(value = "/{shoppingCartItemId}")
	@ResponseBody
	public ShoppingCartItemDTO getShoppingCartItem(@PathVariable Integer shoppingCartItemId) {
		
		return (shoppingCartItemService.getShoppingCartItemDTOById(shoppingCartItemId));
	}

 	@RequestMapping(value = "/addShoppingCartItem", method = RequestMethod.POST)
	public ResponseEntity<?> addShoppingCartItem(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = shoppingCartItemService.addShoppingCartItem(shoppingCartItemDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/shoppingCartItems")
	public ResponseEntity<ShoppingCartItemPageDTO> getShoppingCartItems(ShoppingCartItemSearchDTO shoppingCartItemSearchDTO) {
 
		return shoppingCartItemService.getShoppingCartItems(shoppingCartItemSearchDTO);
	}	

	@RequestMapping(value = "/updateShoppingCartItem", method = RequestMethod.POST)
	public ResponseEntity<?> updateShoppingCartItem(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = shoppingCartItemService.updateShoppingCartItem(shoppingCartItemDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
