package com.java.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.java.entity.District;
import com.java.entity.Province;
import com.java.entity.Ward;
import com.java.repository.DistrictRepository;
import com.java.repository.ProvinceRepository;
import com.java.repository.WardRepository;
import com.java.service.VietnameseAdministrativeUnit;

@Service
@Scope("prototype")
public class VietnameseAdministrativeUnitImpl implements VietnameseAdministrativeUnit{

	private ProvinceRepository repo;
	
	private DistrictRepository repoDistrict;
	
	private WardRepository repoWard;
	public VietnameseAdministrativeUnitImpl(ProvinceRepository repo, DistrictRepository repoDistrict, WardRepository repoWard) {
		this.repo = repo;
		this.repoDistrict = repoDistrict;
		this.repoWard = repoWard;
	}
	
	
	
	@Override
	public List<Province> provinces() {
		List<Province> provinces = repo.findAll();
		return provinces;
	}


	@Override
	public List<District> findDistrictByProvinceId(long provinceId) {
		List<District> districts = repoDistrict.findDistrictByProvinceId(provinceId);
		return districts;
	}



	@Override
	public List<Ward> findWardByDistrictId(long districtId) {
		List<Ward> wards = repoWard.findWardByDistrictId(districtId);
		return wards;
	}



	@Override
	public List<District> districts() {
		List<District> districts = repoDistrict.findAll();
		return districts;
	}



	@Override
	public List<Ward> wards() {
		List<Ward> wards = repoWard.findAll();
		return wards;
	}

}
