package com.java.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.District;
import com.java.entity.Province;
import com.java.entity.Ward;
import com.java.model.Message;
import com.java.service.VietnameseAdministrativeUnit;

@RestController
@RequestMapping("/api/Vietnamese-Administrative-Unit")
public class VietnameseAdministrativeUnitController {
	private VietnameseAdministrativeUnit service;
	
	public VietnameseAdministrativeUnitController(VietnameseAdministrativeUnit service) {
		this.service = service;
	}



	@GetMapping("/provinces/get-all")
	public ResponseEntity<?> getAllProvince(){
		try {
			List<Province> list = service.provinces();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message("Server lỗi", Instant.now(), "500", "Internal Server Error", "/api/Vietnamese-Administrative-Unit/get-all"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/districts/get-all")
	public ResponseEntity<?> getAllDistrict(){
		try {
			List<District> list = service.districts();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message("Server lỗi", Instant.now(), "500", "Internal Server Error", "/api/Vietnamese-Administrative-Unit/get-all"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/wards/get-all")
	public ResponseEntity<?> getAllWard(){
		try {
			List<Ward> list = service.wards();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message("Server lỗi", Instant.now(), "500", "Internal Server Error", "/api/Vietnamese-Administrative-Unit/get-all"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/districts/get-all-by-province-id")
	public ResponseEntity<?> getAllDistrict(@RequestBody HashMap<String, String> request){
		try {
			List<District> list = service.findDistrictByProvinceId(Long.valueOf(request.get("provinceId")));
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message("Server lỗi", Instant.now(), "500", "Internal Server Error", "/api/Vietnamese-Administrative-Unit/get-all"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/wards/get-all-by-district-id")
	public ResponseEntity<?> getAllWard(@RequestBody HashMap<String, String> request){
		try {
			List<Ward> list = service.findWardByDistrictId(Long.valueOf(request.get("districtId")));
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message("Server lỗi", Instant.now(), "500", "Internal Server Error", "/api/Vietnamese-Administrative-Unit/get-all"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
