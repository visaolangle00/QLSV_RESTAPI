package xyz.qlsvrest.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import xyz.qlsvrest.dto.PersonDto;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
	@Id
	//tai sao phai dung auto
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected String Name;
	protected String Code;
	protected String address;
	protected String gender;
	protected Date birthDate;
	
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
	
	public static Person from(PersonDto persondto) {
		Person person = new Person();
		person.setId(persondto.getId());
		person.setName(persondto.getName());
		person.setCode(persondto.getCode());
		person.setAddress(persondto.getAddress());
		person.setGender(persondto.getGender());
		person.setBirthDate((Date) persondto.getBirthDate());
		
		return person;
	}
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person( String name, String code, String address, String gender, Date birthDate) {
		super();
		Name = name;
		Code = code;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
//	@OneToMany(mappedBy = "person")
//	private List<Student> students;
	
	
	
	
}
