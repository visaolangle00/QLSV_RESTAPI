package xyz.qlsvrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import xyz.qlsvrest.model.Department;
import xyz.qlsvrest.model.Project;
import xyz.qlsvrest.model.Teacher;
import xyz.qlsvrest.repository.TeacherRepository;
import xyz.qlsvrest.service.impl.TeacherServiceImpl;

@Service
public class TeacherService implements TeacherServiceImpl  {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public TeacherService(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher deleteTeacher(Integer id) {
		Teacher teacher = getTeacher(id);
		teacherRepository.deleteById(id);
		return teacher;
	}

	@Override
	public Teacher getTeacher(Integer id){
        return teacherRepository.findById(id).orElseThrow();
    }
	
	@Override
	public List<Teacher> getTeachers(){
        List<Teacher> teachers = new ArrayList<>(teacherRepository.findAll());
		return teachers;
    }

	@Override
	@Transactional
	public Teacher editTeacher(Integer id, Teacher teacher){
	       Teacher  teacherToEdit = getTeacher(id);
	       teacherToEdit.setName(teacher.getName());
	       teacherToEdit.setCode(teacher.getCode());
	       teacherToEdit.setAddress(teacher.getAddress());
	       teacherToEdit.setBirthDate(teacher.getBirthDate());
	       teacherToEdit.setGender(teacher.getGender());
	       //teacherToEdit.setDepartment(teacher.getDepartment());
	       
	       if(teacher.getDepartment()!=null) {
	    	 Department department = new Department();
	    	 teacherToEdit.setId(department.getId());
	       }
	       
	       
	        return teacherToEdit;
	    }

	@Override
	public Page<Teacher> getTeacherPage(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Teacher> teacherPage = teacherRepository.findAll(pageable);
		return teacherPage;
	}
	
	
    
	
    
}
