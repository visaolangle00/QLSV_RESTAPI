package xyz.qlsvrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.qlsvrest.dto.CompanyDto;
import xyz.qlsvrest.model.Company;
import xyz.qlsvrest.repository.CompanyRepository;
import xyz.qlsvrest.service.CompanyService;

@RestController
@RequestMapping("/api/companys")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
//	@Autowired
//	private CompanyRepository companyRepository;
	
	@PostMapping
	public ResponseEntity<CompanyDto> saveCompany(@RequestBody final CompanyDto companyDto){
	//	Company company = companyServiceImpl.saveCompany(Company.from(companyDto));
		Company company = companyService.saveCompany(Company.from(companyDto));
		return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
		
		
	}
	
	
	 @GetMapping("/companies")
	 public ResponseEntity<List<CompanyDto>> getAllCompanys() {
		  List<Company> companies = companyService.getCompanys();
		  List<CompanyDto> companyDtos = new ArrayList<>();
		  for (Company company : companies) {
			CompanyDto companyDto = CompanyDto.from(company);
			companyDtos.add(companyDto);
			
		}
		return new ResponseEntity<>(companyDtos, HttpStatus.OK);
	    }
	 
	 
	 @GetMapping(value = "{id}")
	 public ResponseEntity<CompanyDto> getCompany(@PathVariable final Integer id){
        Company company = companyService.getCompany(id);
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }
	
	 @DeleteMapping(value = "{id}")
	    public ResponseEntity<CompanyDto> deleteCompany(@PathVariable final Integer id){
	        Company company = companyService.deleteCompany(id);
	        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
	    }
	
	 @PutMapping(value = "{id}")
	    public ResponseEntity<CompanyDto> editCompany(@PathVariable final Integer id,
	                                            @RequestBody final CompanyDto companyDto){
	        Company editCompany = companyService.editCompany(id, Company.from(companyDto));
	        return new ResponseEntity<>(CompanyDto.from(editCompany), HttpStatus.OK);
	    }
	 
	 
//	 @GetMapping
//	 public ResponseEntity<Page<Company>> getProducts(
//	         @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
//	         @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
//	     Page<CompanyDto> companyDtoPage = companyService.getCompanyPages(pageNumber, pageSize);
//
//	     
//	     List<Company> companyList = new ArrayList<>();
//	     for (CompanyDto companyDto : companyDtoPage) {
//	    	    
//	    	    Company company = new Company(companyDto.getId(), companyDto.getCode(), companyDto.getAddress(), companyDto.getName());
//	    	    companyList.add(company);
//	    	}
//	     
//	     
//	     Pageable pageable = PageRequest.of(
//	         companyDtoPage.getPageable().getPageNumber(),
//	         companyDtoPage.getPageable().getPageSize(),
//	         companyDtoPage.getPageable().getSort()
//	     );
//	     Page<Company> companyPage = new PageImpl<>(companyList, pageable, companyDtoPage.getTotalElements());
//	     return ResponseEntity.ok(companyPage);
//	 }
	 
	 
	 @GetMapping
	    public ResponseEntity<Page<Company>> getCompanyPages(
	            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
	            @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
	        Page<Company> getpages = companyService.getCompanyPage(pageNumber, pageSize);
	        return ResponseEntity.ok(getpages);
	    }
	 
//	 @GetMapping("/name/ending/{name}")
//	    public List<Company> getCompaniesByNameEndingWith(@PathVariable String name) {
//	        return companyService.findByNameEndingWith(name);
//	    }
	 
	 
	 
	 
}
