package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.ShoppingCart;
import com.58ebays.dto.ShoppingCartDTO;
import com.58ebays.dto.ShoppingCartSearchDTO;
import com.58ebays.dto.ShoppingCartPageDTO;
import com.58ebays.dto.ShoppingCartConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ShoppingCartService extends GenericService<ShoppingCart, Integer> {

	List<ShoppingCart> findAll();

	ResultDTO addShoppingCart(ShoppingCartDTO shoppingCartDTO, RequestDTO requestDTO);

	ResultDTO updateShoppingCart(ShoppingCartDTO shoppingCartDTO, RequestDTO requestDTO);

    Page<ShoppingCart> getAllShoppingCarts(Pageable pageable);

    Page<ShoppingCart> getAllShoppingCarts(Specification<ShoppingCart> spec, Pageable pageable);

	ResponseEntity<ShoppingCartPageDTO> getShoppingCarts(ShoppingCartSearchDTO shoppingCartSearchDTO);
	
	List<ShoppingCartDTO> convertShoppingCartsToShoppingCartDTOs(List<ShoppingCart> shoppingCarts, ShoppingCartConvertCriteriaDTO convertCriteria);

	ShoppingCartDTO getShoppingCartDTOById(Integer shoppingCartId);







}





