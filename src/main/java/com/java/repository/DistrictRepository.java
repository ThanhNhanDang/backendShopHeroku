package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{
	
	@Query("SELECT d FROM District d WHERE d.provinceId = :provinceId")
	public List<District> findDistrictByProvinceId(@Param("provinceId") long provinceId);
	
}
