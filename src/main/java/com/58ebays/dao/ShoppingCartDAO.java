package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.ShoppingCart;





public interface ShoppingCartDAO extends GenericDAO<ShoppingCart, Integer> {
  
	List<ShoppingCart> findAll();
	






}


