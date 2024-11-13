package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.ReturnRequest;
import com.58ebays.dto.ReturnRequestDTO;
import com.58ebays.dto.ReturnRequestSearchDTO;
import com.58ebays.dto.ReturnRequestPageDTO;
import com.58ebays.dto.ReturnRequestConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ReturnRequestService extends GenericService<ReturnRequest, Integer> {

	List<ReturnRequest> findAll();

	ResultDTO addReturnRequest(ReturnRequestDTO returnRequestDTO, RequestDTO requestDTO);

	ResultDTO updateReturnRequest(ReturnRequestDTO returnRequestDTO, RequestDTO requestDTO);

    Page<ReturnRequest> getAllReturnRequests(Pageable pageable);

    Page<ReturnRequest> getAllReturnRequests(Specification<ReturnRequest> spec, Pageable pageable);

	ResponseEntity<ReturnRequestPageDTO> getReturnRequests(ReturnRequestSearchDTO returnRequestSearchDTO);
	
	List<ReturnRequestDTO> convertReturnRequestsToReturnRequestDTOs(List<ReturnRequest> returnRequests, ReturnRequestConvertCriteriaDTO convertCriteria);

	ReturnRequestDTO getReturnRequestDTOById(Integer returnRequestId);







}





