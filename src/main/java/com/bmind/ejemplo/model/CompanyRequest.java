package com.bmind.ejemplo.model;

import javax.persistence.Column;

import com.bmind.ejemplo.entity.Company;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class CompanyRequest {
	
	private String identificationNumber;
	private String verificationDigit;
	private String firstName;
	private String otherName;
	private String surname;
	private String secondSurname;
	private String businessName;
	private String direction;
	private String companyCol;
	private String phone;
	
}
