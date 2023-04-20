package xyz.qlsvrest.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import xyz.qlsvrest.model.Company;
import xyz.qlsvrest.model.Student;

public interface StudentServiceImpl {
	List<Student> getStudents();
	
	Student saveStudent(Student student);
	
	Student getStudent(Integer id);
	
	Student deleteStudent(Integer id);
	
	Student editStudent(Integer id, Student student);
	
	Page<Student> getStudentPage(int pageNumber, int pageSize);
}
