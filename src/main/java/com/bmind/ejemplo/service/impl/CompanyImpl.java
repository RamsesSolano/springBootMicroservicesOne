package com.bmind.ejemplo.service.impl;

import java.util.List;
import java.util.Optional;
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
	public List<CompanyResponse> getAllCompanies() {
		List<CompanyResponse> response = null;
		List<Company> listCompany = this.companyJpaRepository.findAll();
		response = listCompany.stream().map( company -> new CompanyResponse(
					company.getId(),
					company.getIdentificationNumber(),
					company.getVerificationDigit(),
					company.getFirstName(),
					company.getOtherName(),
					company.getSecondSurname(),
					company.getSurname(),
					company.getBusinessName(),
					company.getDirection(),
					company.getCompanyCol(),
					company.getPhone()
				) ).collect(Collectors.toList());
		return response;
	}

	@Override
	public CompanyResponse createCompany(CompanyRequest request) {
		Company company = new Company(
					request.getIdentificationNumber(),
					request.getVerificationDigit(),
					request.getFirstName(),
					request.getOtherName(),
					request.getSecondSurname(),
					request.getSurname(),
					request.getBusinessName(),
					request.getDirection(),
					request.getCompanyCol(),
					request.getPhone()
				);
		
		company = this.companyJpaRepository.save(company);
		CompanyResponse response = new CompanyResponse(
					company.getId(),
					company.getIdentificationNumber(),
					company.getVerificationDigit(),
					company.getFirstName(),
					company.getOtherName(),
					company.getSecondSurname(),
					company.getSurname(),
					company.getBusinessName(),
					company.getDirection(),
					company.getCompanyCol(),
					company.getPhone()
				);
		
		return response;
	}

	@Override
	public CompanyResponse deleteCompany(int idCompany) {
		CompanyResponse response = null; 
		Optional<Company> company = this.companyJpaRepository.findById( idCompany );
		if( company.isPresent() == true ) {
			this.companyJpaRepository.deleteById(idCompany);
			response = new CompanyResponse(
					company.get().getId(),
					company.get().getIdentificationNumber(),
					company.get().getVerificationDigit(),
					company.get().getFirstName(),
					company.get().getOtherName(),
					company.get().getSecondSurname(),
					company.get().getSurname(),
					company.get().getBusinessName(),
					company.get().getDirection(),
					company.get().getCompanyCol(),
					company.get().getPhone()
					);
		}
		return response;
	}
	

}
