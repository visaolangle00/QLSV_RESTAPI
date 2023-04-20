package xyz.qlsvrest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import xyz.qlsvrest.dto.ProjectDto;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Name;
	private String Code;
	
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

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
	
	
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	@OneToMany(mappedBy = "project")
	private List<Studentproject> studentProjects;
	

	public static Project from(ProjectDto projectDto) {
		
		Project project = new Project();
		project.setId(projectDto.getId());
		project.setName(projectDto.getName());
		project.setCode(projectDto.getCode());

		if(projectDto.getTeacherId()!=null) {
			Teacher teacher = new Teacher();
			teacher.setId(projectDto.getTeacherId());
			project.setTeacher(teacher);
		}
		return project;
		
	}
	
	
}
