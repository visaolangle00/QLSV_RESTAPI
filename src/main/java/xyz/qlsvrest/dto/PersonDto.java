package xyz.qlsvrest.dto;

import java.util.Date;

import xyz.qlsvrest.model.Person;

public class PersonDto {
	private Integer id;
	private String Name;
	private String Code;
	private String address;
	private String gender;
	private Date birthDate;
	
	
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public PersonDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonDto(Integer id, String name, String code, String address, String gender, Date birthDate) {
		super();
		this.id = id;
		Name = name;
		Code = code;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	public static PersonDto from(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setId(person.getId());
		personDto.setName(person.getName());
		personDto.setCode(person.getCode());
		personDto.setAddress(person.getAddress());
		personDto.setGender(person.getGender());
		personDto.setBirthDate((Date) person.getBirthDate());
		
		return personDto;
	}
}
