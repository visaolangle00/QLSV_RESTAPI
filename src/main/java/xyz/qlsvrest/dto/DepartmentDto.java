package xyz.qlsvrest.dto;

import java.util.List;

import xyz.qlsvrest.model.Department;

public class DepartmentDto {
	private Integer id;
	private  String Name;
	private String Code;
	private Integer parentId;
	
	
//	Nếu bạn muốn trả về danh sách giáo viên 
	//của một phòng ban trong một API hoặc một chức năng nào đó, 
	//thì bạn có thể muốn tạo một DepartmentDTO để truyền thông tin 
	//phòng ban và danh sách giáo viên. 
	//Tuy nhiên, nếu bạn không cần truyền danh sách giáo viên 
	//của một phòng ban trong các truy vấn của mình, 
	//thì không cần phải tạo DepartmentDTO với thuộc 
	private List<TeacherDto> teachers;
	
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public static DepartmentDto from(Department department) {
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setId(department.getId());
		departmentDto.setName(department.getName());
		departmentDto.setCode(department.getCode());
		departmentDto.setParentId(department.getParentId());
		
		return departmentDto;
	}
	
	
	
}
