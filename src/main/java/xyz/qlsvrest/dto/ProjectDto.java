package xyz.qlsvrest.dto;

import xyz.qlsvrest.model.Project;

public class ProjectDto {
	private Integer id;
	private String Name;
	private String Code;
	
	//
	//private ProjectDto projectDto;
		
	private Integer teacherId;

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

//	public ProjectDto getProjectDto() {
//		return projectDto;
//	}
//
//	public void setProjectDto(ProjectDto projectDto) {
//		this.projectDto = projectDto;
//	}
	
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
	
	
	public static ProjectDto from(Project project) {
		
		ProjectDto projectDto = new ProjectDto();
		projectDto.setId(project.getId());
		projectDto.setName(project.getName());
		projectDto.setCode(project.getCode());

		
		if(project.getTeacher()!=null) {
			//projectDto.setId(project.getTeacher().getId());
			
			projectDto.setTeacherId(project.getTeacher().getId());
		}
		
		return projectDto;
		
	}

	
	
	
}

