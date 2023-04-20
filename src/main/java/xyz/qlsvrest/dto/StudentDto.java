package xyz.qlsvrest.dto;

import java.util.Date;

import xyz.qlsvrest.model.Student;

public class StudentDto extends PersonDto {
	private Date year;

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public StudentDto(Date year) {
		super();
		this.year = year;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(Integer id, String name, String code, String address, String gender, Date birthDate) {
		super(id, name, code, address, gender, birthDate);
		// TODO Auto-generated constructor stub
	}
	
	private Integer internId;
	
	private Integer studentprojectId;

	public Integer getInternId() {
		return internId;
	}

	public void setInternId(Integer internId) {
		this.internId = internId;
	}

	public Integer getStudentprojectId() {
		return studentprojectId;
	}

	public void setStudentprojectId(Integer studentprojectId) {
		this.studentprojectId = studentprojectId;
	}
	
	public static StudentDto from (Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setAddress(student.getAddress());
		studentDto.setBirthDate(student.getBirthDate());
		studentDto.setCode(student.getCode());
		studentDto.setGender(student.getGender());
		studentDto.setId(student.getId());
		//studentDto.setInternId(student.getInternId());
		
		if(student.getIntern()!=null) {
			studentDto.setInternId(student.getIntern().getId());
		}
		
		studentDto.setName(student.getName());
		//studentDto.setStudentprojectId(student.getStudentproject());
		
		if(student.getStudentproject()!=null) {
			studentDto.setStudentprojectId(student.getStudentproject().getId());
		}
		
		return studentDto;
		
	}
	
	
	
}
