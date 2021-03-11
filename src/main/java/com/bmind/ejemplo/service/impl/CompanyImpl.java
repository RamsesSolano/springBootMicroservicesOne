package com.bmind.ejemplo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bmind.ejemplo.entity.Company;
import com.bmind.ejemplo.model.CompanyRequest;
import com.bmind.ejemplo.model.CompanyResponse;
import com.bmind.ejemplo.repository.CompanyJpaRepository;
import com.bmind.ejemplo.service.CompanyService;

@Service( "companyImpl" )
public class CompanyImpl implements CompanyService {

	@Autowired
	@Qualifier( "companyJpaRepository" )
	private CompanyJpaRepository companyJpaRepository;
	
	@Override
	public CompanyResponse addCompany(CompanyRequest newCompany) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyResponse> getAllCompanies() {
		List< Company > business =  this.companyJpaRepository.findAll();
		List< CompanyResponse > response = business.stream()
												   .map( company -> new CompanyResponse(
														   company.getId(),
														   company.getIdentificationNumber(),
														   company.getVerificationDigit(),
														   company.getFirstName(),
														   company.getOtherName(),
														   company.getSurname(),
														   company.getSecondSurname(),
														   company.getBusinessName(),
														   company.getDirection(),
														   company.getCompanyCol(),
														   company.getPhone()
														))
												   .collect(Collectors.toList());
		return response;
	}

	@Override
	public CompanyResponse getCompanyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
