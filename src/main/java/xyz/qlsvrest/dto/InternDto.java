package xyz.qlsvrest.dto;

import java.util.Date;

import xyz.qlsvrest.model.Intern;

public class InternDto {
	private Integer id;
	private Float mark;
	private Date startDate;
	private Date endDate;
	
	private Integer companyId;
	
	private Integer teacherId;

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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	public static InternDto from(Intern intern) {
		InternDto internDto = new InternDto();
		
		//internDto.setCompanyId(intern.getCompany());
		if(intern.getCompany()!=null) {
			internDto.setCompanyId(intern.getCompany().getId());
		}
		
		internDto.setEndDate(intern.getEndDate());
		internDto.setId(intern.getId());
		internDto.setMark(intern.getMark());
		internDto.setStartDate(intern.getStartDate());
		
//		internDto.setTeacherId(intern.getTeacher().getId());
		if(intern.getTeacher()!=null) {
			internDto.setTeacherId(intern.getTeacher().getId());
		}
		
		return internDto;
		
	}
	
	
}
