package xyz.qlsvrest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import xyz.qlsvrest.dto.TeacherDto;

@Entity
public class Teacher extends Person {
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	//
	@OneToMany(mappedBy = "teacher")
	private List<Project> projects;
	

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Teacher(String name, String code, String address, String gender, java.util.Date birthDate) {
		super(name, code, address, gender, birthDate);
		// TODO Auto-generated constructor stub
	}
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	//
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public static Teacher from(TeacherDto teacherdto) {
		Teacher teacher = new Teacher();
		teacher.setId(teacherdto.getId());
		teacher.setName(teacherdto.getName());
		teacher.setCode(teacherdto.getCode());
		teacher.setAddress(teacherdto.getAddress());
		teacher.setGender(teacherdto.getGender());
		//teacher.setBirthDate((Date) teacherdto.getBirthDate());
		
		teacher.setBirthDate( teacherdto.getBirthDate());
		
		//teacher.setDepartment(getDepartmentbyId(teacherDto.getId()));
		
		 if (teacherdto.getDepartmentId() != null) {
	            Department department = new Department();
	            department.setId(teacherdto.getDepartmentId());
	            teacher.setDepartment(department);
	        }
		
		return teacher;
	}
	
	@OneToMany(mappedBy = "teacher")
	private List<Intern> interns;
	
	
	 
}
