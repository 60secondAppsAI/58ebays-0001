package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.ShippingInfo;





public interface ShippingInfoDAO extends GenericDAO<ShippingInfo, Integer> {
  
	List<ShippingInfo> findAll();
	






}


