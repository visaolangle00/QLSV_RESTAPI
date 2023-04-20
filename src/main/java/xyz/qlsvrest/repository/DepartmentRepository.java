package xyz.qlsvrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.qlsvrest.model.Company;
import xyz.qlsvrest.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}
