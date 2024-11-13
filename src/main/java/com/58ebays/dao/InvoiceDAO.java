package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.Invoice;





public interface InvoiceDAO extends GenericDAO<Invoice, Integer> {
  
	List<Invoice> findAll();
	






}


