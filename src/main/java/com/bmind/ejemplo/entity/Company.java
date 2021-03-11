package com.bmind.ejemplo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name="company" )

@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column( name="identification_number" )
	private String identificationNumber;
	
	@Column( name="verification_digit" )
	private String verificationDigit;
	
	@Column( name="first_name" )
	private String firstName;
	
	@Column( name="other_name" )
	private String otherName;
	
	@Column( name="surname" )
	private String surname;
	
	@Column( name="second_surname" )
	private String secondSurname;
	
	@Column( name="business_name" )
	private String businessName;
	
	@Column( name="direction" )
	private String direction;
	
	@Column( name="companycol" )
	private String companyCol;
	
	@Column( name="phone" )
	private String phone;
}
