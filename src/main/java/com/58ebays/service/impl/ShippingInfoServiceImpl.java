package com.58ebays.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.58ebays.dao.GenericDAO;
import com.58ebays.service.GenericService;
import com.58ebays.service.impl.GenericServiceImpl;
import com.58ebays.dao.ShippingInfoDAO;
import com.58ebays.domain.ShippingInfo;
import com.58ebays.dto.ShippingInfoDTO;
import com.58ebays.dto.ShippingInfoSearchDTO;
import com.58ebays.dto.ShippingInfoPageDTO;
import com.58ebays.dto.ShippingInfoConvertCriteriaDTO;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import com.58ebays.service.ShippingInfoService;
import com.58ebays.util.ControllerUtils;





@Service
public class ShippingInfoServiceImpl extends GenericServiceImpl<ShippingInfo, Integer> implements ShippingInfoService {

    private final static Logger logger = LoggerFactory.getLogger(ShippingInfoServiceImpl.class);

	@Autowired
	ShippingInfoDAO shippingInfoDao;

	


	@Override
	public GenericDAO<ShippingInfo, Integer> getDAO() {
		return (GenericDAO<ShippingInfo, Integer>) shippingInfoDao;
	}
	
	public List<ShippingInfo> findAll () {
		List<ShippingInfo> shippingInfos = shippingInfoDao.findAll();
		
		return shippingInfos;	
		
	}

	public ResultDTO addShippingInfo(ShippingInfoDTO shippingInfoDTO, RequestDTO requestDTO) {

		ShippingInfo shippingInfo = new ShippingInfo();

		shippingInfo.setShippingInfoId(shippingInfoDTO.getShippingInfoId());


		shippingInfo.setShippingDate(shippingInfoDTO.getShippingDate());


		shippingInfo.setCourier(shippingInfoDTO.getCourier());


		shippingInfo.setTrackingNumber(shippingInfoDTO.getTrackingNumber());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		shippingInfo = shippingInfoDao.save(shippingInfo);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<ShippingInfo> getAllShippingInfos(Pageable pageable) {
		return shippingInfoDao.findAll(pageable);
	}

	public Page<ShippingInfo> getAllShippingInfos(Specification<ShippingInfo> spec, Pageable pageable) {
		return shippingInfoDao.findAll(spec, pageable);
	}

	public ResponseEntity<ShippingInfoPageDTO> getShippingInfos(ShippingInfoSearchDTO shippingInfoSearchDTO) {
	
			Integer shippingInfoId = shippingInfoSearchDTO.getShippingInfoId(); 
   			String courier = shippingInfoSearchDTO.getCourier(); 
 			String trackingNumber = shippingInfoSearchDTO.getTrackingNumber(); 
 			String sortBy = shippingInfoSearchDTO.getSortBy();
			String sortOrder = shippingInfoSearchDTO.getSortOrder();
			String searchQuery = shippingInfoSearchDTO.getSearchQuery();
			Integer page = shippingInfoSearchDTO.getPage();
			Integer size = shippingInfoSearchDTO.getSize();

	        Specification<ShippingInfo> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, shippingInfoId, "shippingInfoId"); 
			
 			
			spec = ControllerUtils.andIfNecessary(spec, courier, "courier"); 
			
			spec = ControllerUtils.andIfNecessary(spec, trackingNumber, "trackingNumber"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("courier")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("trackingNumber")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<ShippingInfo> shippingInfos = this.getAllShippingInfos(spec, pageable);
		
		//System.out.println(String.valueOf(shippingInfos.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(shippingInfos.getTotalPages()));
		
		List<ShippingInfo> shippingInfosList = shippingInfos.getContent();
		
		ShippingInfoConvertCriteriaDTO convertCriteria = new ShippingInfoConvertCriteriaDTO();
		List<ShippingInfoDTO> shippingInfoDTOs = this.convertShippingInfosToShippingInfoDTOs(shippingInfosList,convertCriteria);
		
		ShippingInfoPageDTO shippingInfoPageDTO = new ShippingInfoPageDTO();
		shippingInfoPageDTO.setShippingInfos(shippingInfoDTOs);
		shippingInfoPageDTO.setTotalElements(shippingInfos.getTotalElements());
		return ResponseEntity.ok(shippingInfoPageDTO);
	}

	public List<ShippingInfoDTO> convertShippingInfosToShippingInfoDTOs(List<ShippingInfo> shippingInfos, ShippingInfoConvertCriteriaDTO convertCriteria) {
		
		List<ShippingInfoDTO> shippingInfoDTOs = new ArrayList<ShippingInfoDTO>();
		
		for (ShippingInfo shippingInfo : shippingInfos) {
			shippingInfoDTOs.add(convertShippingInfoToShippingInfoDTO(shippingInfo,convertCriteria));
		}
		
		return shippingInfoDTOs;

	}
	
	public ShippingInfoDTO convertShippingInfoToShippingInfoDTO(ShippingInfo shippingInfo, ShippingInfoConvertCriteriaDTO convertCriteria) {
		
		ShippingInfoDTO shippingInfoDTO = new ShippingInfoDTO();
		
		shippingInfoDTO.setShippingInfoId(shippingInfo.getShippingInfoId());

	
		shippingInfoDTO.setShippingDate(shippingInfo.getShippingDate());

	
		shippingInfoDTO.setCourier(shippingInfo.getCourier());

	
		shippingInfoDTO.setTrackingNumber(shippingInfo.getTrackingNumber());

	

		
		return shippingInfoDTO;
	}

	public ResultDTO updateShippingInfo(ShippingInfoDTO shippingInfoDTO, RequestDTO requestDTO) {
		
		ShippingInfo shippingInfo = shippingInfoDao.getById(shippingInfoDTO.getShippingInfoId());

		shippingInfo.setShippingInfoId(ControllerUtils.setValue(shippingInfo.getShippingInfoId(), shippingInfoDTO.getShippingInfoId()));

		shippingInfo.setShippingDate(ControllerUtils.setValue(shippingInfo.getShippingDate(), shippingInfoDTO.getShippingDate()));

		shippingInfo.setCourier(ControllerUtils.setValue(shippingInfo.getCourier(), shippingInfoDTO.getCourier()));

		shippingInfo.setTrackingNumber(ControllerUtils.setValue(shippingInfo.getTrackingNumber(), shippingInfoDTO.getTrackingNumber()));



        shippingInfo = shippingInfoDao.save(shippingInfo);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public ShippingInfoDTO getShippingInfoDTOById(Integer shippingInfoId) {
	
		ShippingInfo shippingInfo = shippingInfoDao.getById(shippingInfoId);
			
		
		ShippingInfoConvertCriteriaDTO convertCriteria = new ShippingInfoConvertCriteriaDTO();
		return(this.convertShippingInfoToShippingInfoDTO(shippingInfo,convertCriteria));
	}







}
