package com.bmind.ejemplo.service;

import java.text.CompactNumberFormat;
import java.util.List;

import com.bmind.ejemplo.model.CompanyRequest;
import com.bmind.ejemplo.model.CompanyResponse;

public interface CompanyService {
	public abstract CompanyResponse addCompany( CompanyRequest newCompany );
	public abstract List< CompanyResponse > getAllCompanies();
	public abstract CompanyResponse getCompanyById( int id );
}