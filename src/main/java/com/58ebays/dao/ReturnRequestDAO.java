package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.ReturnRequest;





public interface ReturnRequestDAO extends GenericDAO<ReturnRequest, Integer> {
  
	List<ReturnRequest> findAll();
	






}


