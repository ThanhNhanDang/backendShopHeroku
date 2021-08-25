package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long>{

}
