package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.entity.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long>{
	@Query("SELECT w FROM Ward w WHERE w.districtId = :districtId")
	public List<Ward> findWardByDistrictId(@Param("districtId") long districtId);
}
