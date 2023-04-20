package xyz.qlsvrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import xyz.qlsvrest.model.Student;
import xyz.qlsvrest.model.Studentproject;
import xyz.qlsvrest.model.Teacher;
import xyz.qlsvrest.repository.StudentRepository;
import xyz.qlsvrest.service.impl.StudentServiceImpl;

@Service
public class StudentService implements StudentServiceImpl {
	
	@Autowired
	private StudentRepository studentRepository;
	
	

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = new  ArrayList<>(studentRepository.findAll());
		return students;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).orElseThrow();
	}

	@Override
	public Student deleteStudent(Integer id) {
		Student student = getStudent(id);
		studentRepository.delete(student);
		return student;
	}

	@Override
	@Transactional
	public Student editStudent(Integer id, Student student) {
		Student studentToEdit = getStudent(id);
		
		studentToEdit.setAddress(student.getAddress());
		studentToEdit.setBirthDate(student.getBirthDate());
		studentToEdit.setCode(student.getCode());
		studentToEdit.setGender(student.getGender());
		//studentToEdit.setId(student.getId());
		
		studentToEdit.setIntern(student.getIntern());
		studentToEdit.setName(student.getName());
		studentToEdit.setStudentproject(student.getStudentproject());
		studentToEdit.setYear(student.getYear());
		
		return studentToEdit;
	}

	@Override
	public Page<Student> getStudentPage(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> teacherPage = studentRepository.findAll(pageable);
		return teacherPage;
	}

}
