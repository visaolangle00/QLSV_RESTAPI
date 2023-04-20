package xyz.qlsvrest.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import xyz.qlsvrest.model.Project;
import xyz.qlsvrest.model.Teacher;

public interface TeacherServiceImpl {

	Teacher editTeacher(Integer id, Teacher teacher);

	List<Teacher> getTeachers();

	Teacher getTeacher(Integer id);

	Teacher deleteTeacher(Integer id);

	Teacher saveTeacher(Teacher teacher);
	
	Page<Teacher> getTeacherPage(int pageNumber, int pageSize);

}