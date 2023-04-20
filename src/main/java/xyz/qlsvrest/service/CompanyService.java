package xyz.qlsvrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import xyz.qlsvrest.dto.CompanyDto;
import xyz.qlsvrest.model.Company;
import xyz.qlsvrest.repository.CompanyRepository;
import xyz.qlsvrest.service.impl.CompanyServiceImpl;

@Service
public class CompanyService implements CompanyServiceImpl {

	@Autowired
	private CompanyRepository companyRepository;

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getCompanys() {
		List<Company> companies = new ArrayList<>(companyRepository.findAll());
		return companies;
	}

	@Override
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company getCompany(Integer id) {
		return companyRepository.findById(id).orElseThrow();
	}

	@Override
	public Company deleteCompany(Integer id) {
		Company company = getCompany(id);
		companyRepository.delete(company);
		return company;
	}

	@Override
	@Transactional
	public Company editCompany(Integer id, Company company) {
		Company companyToEdit = getCompany(id);
		companyToEdit.setName(company.getName());
		companyToEdit.setCode(company.getCode());
		companyToEdit.setAddress(company.getAddress());
		return companyToEdit;
	}

//	@Override
//	public Page<Company> getCompanyPage(int pageNumber, int pageSize) {
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		Page<Company> companyPage = companyRepository.findAll(pageable);
//		return companyPage;
//	}

	@Override
	public Page<Company> getCompanyPage(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Company> companyPage = companyRepository.findAll(pageable);
		return companyPage;
	}

//	@Override
//	public List<Company> findByNameEndingWith(String name) {
//		return companyRepository.findByNameEndingWith(name);
//	}
	
//	public Page<CompanyDto> getCompanyPages(int pageNumber, int pageSize) {
//	    Pageable pageable = PageRequest.of(pageNumber, pageSize);
//	    Page<Company> companyPage = companyRepository.findAll(pageable);
//
//	    List<CompanyDto> companyDtoList = new ArrayList<>();
//	    List<Company> companyList = companyPage.getContent();
//
//	    for (Company company : companyList) {
//	        CompanyDto companyDto = new CompanyDto();
//	        companyDto.setId(company.getId());
//	        companyDto.setName(company.getName());
//	        companyDto.setAddress(company.getAddress());
//	        companyDtoList.add(companyDto);
//	    }
//
//	    return new PageImpl<>(companyDtoList, pageable, companyPage.getTotalElements());
//	}


}
