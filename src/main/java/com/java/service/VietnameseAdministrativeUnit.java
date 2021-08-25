package com.java.service;

import java.util.List;

import com.java.entity.District;
import com.java.entity.Province;
import com.java.entity.Ward;

public interface VietnameseAdministrativeUnit {
	List<Province> provinces();
	List<District> districts();
	List<Ward> wards();
	List<District>  findDistrictByProvinceId(long provinceId);
	List<Ward> findWardByDistrictId(long districtId);
}
