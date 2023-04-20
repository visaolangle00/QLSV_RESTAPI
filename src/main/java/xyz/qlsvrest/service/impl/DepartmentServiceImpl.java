package xyz.qlsvrest.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import xyz.qlsvrest.model.Company;
import xyz.qlsvrest.model.Department;

public interface DepartmentServiceImpl {
	List<Department> getDepartments();
	Department saveDepartment(Department department);
	Department getDepartment(Integer id);
	Department deleteDepartment(Integer id);
	Department editDepartment(Integer id, Department department);
	
	Page<Department> getDepartmentPage(int pageNumber, int pageSize);
	
}
