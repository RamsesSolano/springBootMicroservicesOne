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
	public CompanyResponse addCompany(CompanyRequest newCompany) {
		Company newCompanyToSave = new Company(
				newCompany.getVerificationDigit(),
				newCompany.getIdentificationNumber(),
				newCompany.getFirstName(),
				newCompany.getOtherName(),
				newCompany.getSurname(),
				newCompany.getSecondSurname(),
				newCompany.getDirection(),
				newCompany.getCompanyCol(),
				newCompany.getPhone(),
				newCompany.getBusinessName()
				);
		newCompanyToSave = this.companyJpaRepository.save(newCompanyToSave);
		return new CompanyResponse(
				newCompanyToSave.getId(),
				newCompanyToSave.getVerificationDigit(),
				newCompanyToSave.getIdentificationNumber(),
				newCompanyToSave.getFirstName(),
				newCompanyToSave.getOtherName(),
				newCompanyToSave.getSurname(),
				newCompanyToSave.getSecondSurname(),
				newCompanyToSave.getDirection(),
				newCompanyToSave.getCompanyCol(),
				newCompanyToSave.getPhone(),
				newCompanyToSave.getBusinessName()
				);
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
	public Optional < CompanyResponse > getCompanyById(int id) {
		CompanyResponse response = null;
		Optional<Company> company = this.companyJpaRepository.findById(id);
		if( company.isPresent() == true ) {
			response = new CompanyResponse(
					company.get().getId(),
					company.get().getVerificationDigit(),
					company.get().getIdentificationNumber(),
					company.get().getFirstName(),
					company.get().getOtherName(),
					company.get().getSurname(),
					company.get().getSecondSurname(),
					company.get().getDirection(),
					company.get().getCompanyCol(),
					company.get().getPhone(),
					company.get().getBusinessName()
					);
			
		}
		return Optional.of(response);
	}

}
