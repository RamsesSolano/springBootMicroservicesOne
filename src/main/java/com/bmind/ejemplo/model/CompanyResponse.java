package com.bmind.ejemplo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class CompanyResponse {
	
	private int id;
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
