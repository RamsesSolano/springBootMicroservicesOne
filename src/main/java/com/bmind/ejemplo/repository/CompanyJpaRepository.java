package com.bmind.ejemplo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmind.ejemplo.entity.Company;

@Repository("companyJpaRepository")
public interface CompanyJpaRepository extends JpaRepository<Company, Serializable> {

}
