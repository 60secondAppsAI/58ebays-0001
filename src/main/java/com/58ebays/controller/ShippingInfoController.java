package com.58ebays.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.58ebays.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.58ebays.domain.ShippingInfo;
import com.58ebays.dto.ShippingInfoDTO;
import com.58ebays.dto.ShippingInfoSearchDTO;
import com.58ebays.dto.ShippingInfoPageDTO;
import com.58ebays.service.ShippingInfoService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/shippingInfo")
@RestController
public class ShippingInfoController {

	private final static Logger logger = LoggerFactory.getLogger(ShippingInfoController.class);

	@Autowired
	ShippingInfoService shippingInfoService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<ShippingInfo> getAll() {

		List<ShippingInfo> shippingInfos = shippingInfoService.findAll();
		
		return shippingInfos;	
	}

	@GetMapping(value = "/{shippingInfoId}")
	@ResponseBody
	public ShippingInfoDTO getShippingInfo(@PathVariable Integer shippingInfoId) {
		
		return (shippingInfoService.getShippingInfoDTOById(shippingInfoId));
	}

 	@RequestMapping(value = "/addShippingInfo", method = RequestMethod.POST)
	public ResponseEntity<?> addShippingInfo(@RequestBody ShippingInfoDTO shippingInfoDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = shippingInfoService.addShippingInfo(shippingInfoDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/shippingInfos")
	public ResponseEntity<ShippingInfoPageDTO> getShippingInfos(ShippingInfoSearchDTO shippingInfoSearchDTO) {
 
		return shippingInfoService.getShippingInfos(shippingInfoSearchDTO);
	}	

	@RequestMapping(value = "/updateShippingInfo", method = RequestMethod.POST)
	public ResponseEntity<?> updateShippingInfo(@RequestBody ShippingInfoDTO shippingInfoDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = shippingInfoService.updateShippingInfo(shippingInfoDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
