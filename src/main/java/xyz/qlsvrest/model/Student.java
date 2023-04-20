package xyz.qlsvrest.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import xyz.qlsvrest.dto.StudentDto;
import jakarta.persistence.*;

@Entity
public class Student extends Person  {
	
	private Date year;

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String code, String address, String gender, Date birthDate) {
		super(name, code, address, gender, birthDate);
		// TODO Auto-generated constructor stub
	}
	
//	@ManyToOne
//	private Person person;
	
//	@OneToMany(mappedBy = "student")
//	private List<Ssp> ssps;
	
	@ManyToOne
	private Intern intern;
	
	@ManyToOne
	private Studentproject studentproject;
	
	
	
	//
//	@ManyToMany
//    @JoinTable(name = "test",
//        joinColumns = @JoinColumn(name = "student_id"),
//        inverseJoinColumns = @JoinColumn(name = "studentproject_id"))
//    private List<Studentproject> studentprojects;

	
	public Intern getIntern() {
		return intern;
	}

	public void setIntern(Intern intern) {
		this.intern = intern;
	}

	public Studentproject getStudentproject() {
		return studentproject;
	}

	public void setStudentproject(Studentproject studentproject) {
		this.studentproject = studentproject;
	}

	public static Student from(StudentDto studentDto) {
		Student student = new Student();
		student.setAddress(studentDto.getAddress());
		student.setBirthDate((Date) studentDto.getBirthDate());
		student.setCode(studentDto.getCode());
		student.setGender(studentDto.getGender());
		student.setId(studentDto.getId());
		student.setName(studentDto.getName());
		student.setYear((Date) studentDto.getYear());
		
		if(studentDto.getStudentprojectId() !=null) {
			Studentproject studentproject = new Studentproject();
			studentproject.setId(studentDto.getStudentprojectId());
			student.setStudentproject(studentproject);
		}
		
		//student.setIntern(studentDto.getInternId());
		
		if(studentDto.getInternId()!=null) {
			Intern intern = new Intern();
			intern.setId(studentDto.getInternId());
			student.setIntern(intern);
		}
				
		return student;
		
	}
	
	
	
}
