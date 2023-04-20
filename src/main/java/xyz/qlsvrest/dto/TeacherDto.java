package xyz.qlsvrest.dto;

import java.util.Date;

import xyz.qlsvrest.model.Teacher;

public class TeacherDto extends PersonDto {
	
	private Integer departmentId;
	
	public TeacherDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TeacherDto(Integer id, String name, String code, String address, String gender, Date birthDate) {
		super(id, name, code, address, gender, birthDate);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public static TeacherDto from(Teacher teacher) {
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setId(teacher.getId());
		teacherDto.setName(teacher.getName());
		teacherDto.setCode(teacher.getCode());
		teacherDto.setAddress(teacher.getAddress());
		teacherDto.setGender(teacher.getGender());
		teacherDto.setBirthDate((Date) teacher.getBirthDate());
		
		if(teacher.getDepartment()!=null) {
			teacherDto.setDepartmentId(teacher.getDepartment().getId());
		}
		
		//teacher.setDepartment(getDepartmentbyId(teacherDto.getId()));
		return teacherDto;
	}
}
