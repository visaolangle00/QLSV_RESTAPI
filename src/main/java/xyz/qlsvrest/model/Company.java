package xyz.qlsvrest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import xyz.qlsvrest.dto.CompanyDto;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Integer id, String name, String code, String address) {
		super();
		this.id = id;
		Name = name;
		Code = code;
		this.address = address;
	}
//	public static Company converttoEnity(CompanyDto companyDto) {
//		
//		Company company = new Company();
//		company.setId(company.getId());
//		company.setName(company.getName());
//		company.setCode(company.getCode());
//		company.setAddress(company.getAddress()); 
//		
//		return company;
//		
//	}

	// loi
//	public static Company from (CompanyDto companyDto) {
//		
//		Company company = new Company();
//		//company.setId(company.getId());
//		company.setName(company.getName());
//		company.setCode(company.getCode());
//		company.setAddress(company.getAddress()); 
//		
//		return company;
//		
//	}

	public static Company from(CompanyDto companyDto) {
		Company company = new Company();
		// quan trong cai de...
		company.setId(companyDto.getId());
		company.setName(companyDto.getName());
		company.setAddress(companyDto.getAddress());
		company.setCode(companyDto.getCode());

		return company;
	}

	@OneToMany(mappedBy = "company")
	private List<Intern> interns;

}
