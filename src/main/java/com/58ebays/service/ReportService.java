package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.Report;
import com.58ebays.dto.ReportDTO;
import com.58ebays.dto.ReportSearchDTO;
import com.58ebays.dto.ReportPageDTO;
import com.58ebays.dto.ReportConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ReportService extends GenericService<Report, Integer> {

	List<Report> findAll();

	ResultDTO addReport(ReportDTO reportDTO, RequestDTO requestDTO);

	ResultDTO updateReport(ReportDTO reportDTO, RequestDTO requestDTO);

    Page<Report> getAllReports(Pageable pageable);

    Page<Report> getAllReports(Specification<Report> spec, Pageable pageable);

	ResponseEntity<ReportPageDTO> getReports(ReportSearchDTO reportSearchDTO);
	
	List<ReportDTO> convertReportsToReportDTOs(List<Report> reports, ReportConvertCriteriaDTO convertCriteria);

	ReportDTO getReportDTOById(Integer reportId);







}





