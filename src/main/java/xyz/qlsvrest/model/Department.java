package xyz.qlsvrest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import xyz.qlsvrest.dto.DepartmentDto;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Name;
	private String Code;
	private Integer parentId;
	public Integer getId() {
		return id;
	}
	
	@OneToMany(mappedBy = "department")
    private List<Teacher> teachers;
	
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
	//
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	//
	
	public static Department from(DepartmentDto departmentDto) {
		Department department = new Department();
		// quan trong cai de...
		department.setId(departmentDto.getId());
		department.setName(departmentDto.getName());
		department.setParentId(departmentDto.getParentId());
		department.setCode(departmentDto.getCode());
		
		return department;
	}
	
	
}
