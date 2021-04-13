package com.bmind.ejemplo.service;

import java.text.CompactNumberFormat;
import java.util.List;
import java.util.Optional;

import com.bmind.ejemplo.model.CompanyRequest;
import com.bmind.ejemplo.model.CompanyResponse;

public interface CompanyService {
	public abstract List< CompanyResponse > getAllCompanies();
	public abstract CompanyResponse createCompany( CompanyRequest request );
	public abstract CompanyResponse deleteCompany( int idCompany );
}
