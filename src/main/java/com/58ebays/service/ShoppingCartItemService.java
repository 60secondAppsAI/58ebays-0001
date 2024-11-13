package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.ShoppingCartItem;
import com.58ebays.dto.ShoppingCartItemDTO;
import com.58ebays.dto.ShoppingCartItemSearchDTO;
import com.58ebays.dto.ShoppingCartItemPageDTO;
import com.58ebays.dto.ShoppingCartItemConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ShoppingCartItemService extends GenericService<ShoppingCartItem, Integer> {

	List<ShoppingCartItem> findAll();

	ResultDTO addShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO, RequestDTO requestDTO);

	ResultDTO updateShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO, RequestDTO requestDTO);

    Page<ShoppingCartItem> getAllShoppingCartItems(Pageable pageable);

    Page<ShoppingCartItem> getAllShoppingCartItems(Specification<ShoppingCartItem> spec, Pageable pageable);

	ResponseEntity<ShoppingCartItemPageDTO> getShoppingCartItems(ShoppingCartItemSearchDTO shoppingCartItemSearchDTO);
	
	List<ShoppingCartItemDTO> convertShoppingCartItemsToShoppingCartItemDTOs(List<ShoppingCartItem> shoppingCartItems, ShoppingCartItemConvertCriteriaDTO convertCriteria);

	ShoppingCartItemDTO getShoppingCartItemDTOById(Integer shoppingCartItemId);







}





