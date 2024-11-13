package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.ShoppingCartItem;





public interface ShoppingCartItemDAO extends GenericDAO<ShoppingCartItem, Integer> {
  
	List<ShoppingCartItem> findAll();
	






}


