package xyz.qlsvrest.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import xyz.qlsvrest.model.Company;

public interface CompanyServiceImpl {
	List<Company> getCompanys();
	
	Company saveCompany(Company company);
	
	Company getCompany(Integer id);
	
	Company deleteCompany(Integer id);
	
	Company editCompany(Integer id, Company company);
	
//	Page<Company> getCompanyPage(int pageNumber, int pageSize);
	
	Page<Company> getCompanyPage(int pageNumber, int pageSize);
	
//	 List<Company> findByNameEndingWith(String name);
	
}
