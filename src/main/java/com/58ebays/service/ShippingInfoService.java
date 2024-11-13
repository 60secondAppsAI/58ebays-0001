package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.ShippingInfo;
import com.58ebays.dto.ShippingInfoDTO;
import com.58ebays.dto.ShippingInfoSearchDTO;
import com.58ebays.dto.ShippingInfoPageDTO;
import com.58ebays.dto.ShippingInfoConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ShippingInfoService extends GenericService<ShippingInfo, Integer> {

	List<ShippingInfo> findAll();

	ResultDTO addShippingInfo(ShippingInfoDTO shippingInfoDTO, RequestDTO requestDTO);

	ResultDTO updateShippingInfo(ShippingInfoDTO shippingInfoDTO, RequestDTO requestDTO);

    Page<ShippingInfo> getAllShippingInfos(Pageable pageable);

    Page<ShippingInfo> getAllShippingInfos(Specification<ShippingInfo> spec, Pageable pageable);

	ResponseEntity<ShippingInfoPageDTO> getShippingInfos(ShippingInfoSearchDTO shippingInfoSearchDTO);
	
	List<ShippingInfoDTO> convertShippingInfosToShippingInfoDTOs(List<ShippingInfo> shippingInfos, ShippingInfoConvertCriteriaDTO convertCriteria);

	ShippingInfoDTO getShippingInfoDTOById(Integer shippingInfoId);







}





