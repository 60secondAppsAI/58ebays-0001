package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.Report;





public interface ReportDAO extends GenericDAO<Report, Integer> {
  
	List<Report> findAll();
	






}


