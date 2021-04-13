package com.bmind.ejemplo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bmind.ejemplo.model.CompanyRequest;
import com.bmind.ejemplo.model.CompanyResponse;
import com.bmind.ejemplo.service.CompanyService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin( origins = "*", methods = {
		RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH
})
public class CompanyController {

	@Autowired
	@Qualifier("companyImpl")
	private CompanyService companyService;
	
	@GetMapping( "/company" )
	public ResponseEntity getAllBuysiness() {
		List<CompanyResponse> response = this.companyService.getAllCompanies();
		return new ResponseEntity( response, HttpStatus.OK );
	}
	
	@DeleteMapping( "/company/{id}" )
	public ResponseEntity deleteCompany( @PathVariable("id") int id ) {
		CompanyResponse response = this.companyService.deleteCompany(id);
		return new ResponseEntity( response, HttpStatus.OK );
	}
	
	@PostMapping( "/company" )
	public ResponseEntity addCompany( @RequestBody CompanyRequest newCompany ) {
		CompanyResponse response = this.companyService.createCompany(newCompany);
		return new ResponseEntity( response, HttpStatus.OK );
	}
}
