package xyz.qlsvrest.dto;

import xyz.qlsvrest.model.Company;

public class CompanyDto {
	private Integer id;
	private String Name;
	private String Code;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static CompanyDto from (Company company) {
		CompanyDto companyDto = new CompanyDto();
		companyDto.setId(company.getId());
		companyDto.setName(company.getName());
		companyDto.setCode(company.getCode());
		companyDto.setAddress(company.getAddress());
		
		return companyDto;
		
	}

	
	
}
