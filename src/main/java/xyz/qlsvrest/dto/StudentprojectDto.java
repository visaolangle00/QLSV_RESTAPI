package xyz.qlsvrest.dto;

import java.util.Date;

import xyz.qlsvrest.model.Studentproject;

public class StudentprojectDto {
	private Integer id;
	private Float mark;
	private Date startDate;
	private Date endDate;
	
	private Integer projectId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public static StudentprojectDto from (Studentproject studentproject) {
		StudentprojectDto studentprojectDto = new StudentprojectDto();
		studentprojectDto.setEndDate(studentproject.getEndDate());
		studentprojectDto.setId(studentproject.getId());
		studentprojectDto.setMark(studentproject.getMark());
		//studentprojectDto.setProjectId(studentproject.getProject().getId());
		
		if(studentproject.getProject()!=null) {
			studentprojectDto.setProjectId(studentproject.getProject().getId());
		}
		
		studentprojectDto.setStartDate(studentproject.getStartDate());
		
		return studentprojectDto;
	}
	
	
}
