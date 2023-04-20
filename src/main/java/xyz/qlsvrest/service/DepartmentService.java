package xyz.qlsvrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import xyz.qlsvrest.model.Company;
import xyz.qlsvrest.model.Department;
import xyz.qlsvrest.repository.DepartmentRepository;
import xyz.qlsvrest.service.impl.DepartmentServiceImpl;

@Service
public class DepartmentService implements DepartmentServiceImpl {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>(departmentRepository.findAll());
		return departments;
	}

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartment(Integer id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).orElseThrow();
	}

	@Override
	public Department deleteDepartment(Integer id) {
		// TODO Auto-generated method stub
		Department department = getDepartment(id);
		
		departmentRepository.delete(department);
		
		return department;
		
	}

	@Override
	@Transactional
	public Department editDepartment(Integer id, Department department) {
		 Department  departmentToEdit = getDepartment(id);
	       departmentToEdit.setName(department.getName());
	       departmentToEdit.setCode(department.getCode());
	       departmentToEdit.setParentId(department.getParentId());
	        return departmentToEdit;
	}

	@Override
	public Page<Department> getDepartmentPage(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Department> departmentPage = departmentRepository.findAll(pageable);
		return departmentPage;
	}

}
