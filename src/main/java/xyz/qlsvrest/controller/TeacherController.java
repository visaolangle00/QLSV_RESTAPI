package xyz.qlsvrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.qlsvrest.dto.TeacherDto;
import xyz.qlsvrest.model.Project;
import xyz.qlsvrest.model.Teacher;
import xyz.qlsvrest.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping
	public ResponseEntity<TeacherDto> saveTeacher(@RequestBody TeacherDto teacherDto){
		Teacher teacher = teacherService.saveTeacher(Teacher.from(teacherDto));
		return new ResponseEntity<>(TeacherDto.from(teacher), HttpStatus.OK);
		
	}
	
	
	 @GetMapping("/teacherses")
	 public ResponseEntity<List<TeacherDto>> getAllTeachers() {
		  List<Teacher> companies = teacherService.getTeachers();
		  List<TeacherDto> teacherDtos = new ArrayList<>();
		  for (Teacher teacher : companies) {
			TeacherDto teacherDto = TeacherDto.from(teacher);
			teacherDtos.add(teacherDto);
		}
			return new ResponseEntity<>(teacherDtos, HttpStatus.OK);
	    }
	 
	 
	 @GetMapping(value = "{id}")
	 public ResponseEntity<TeacherDto> getTeacher(@PathVariable final Integer id){        
        Teacher teacher = teacherService.getTeacher(id);
        return new ResponseEntity<>(TeacherDto.from(teacher), HttpStatus.OK);
	 }
	
	 @DeleteMapping(value = "{id}")
	    public ResponseEntity<TeacherDto> deleteTeacher(@PathVariable final Integer id){	        
	        Teacher teacher = teacherService.deleteTeacher(id);
	        return new ResponseEntity<>(TeacherDto.from(teacher), HttpStatus.OK);
	        
	    }
	
	 	@PutMapping(value = "{id}")
	    public ResponseEntity<TeacherDto> editTeacher(@PathVariable final Integer id,
	                                            @RequestBody final TeacherDto teacherDto){	        
	        Teacher editTeacher = teacherService.editTeacher(id, Teacher.from(teacherDto)); 
	        return new ResponseEntity<>(TeacherDto.from(editTeacher), HttpStatus.OK);
	        
	    }
	 	
//	 	Page<TeacherDto> teacherDtoPage = teacherPage.map(teacher -> mapper.map(teacher, TeacherDto.class));
	 	
	 	 @GetMapping
		    public ResponseEntity<Page<Teacher>> getTeacherPages(
		            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
		            @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
		        Page<Teacher> getpages = teacherService.getTeacherPage(pageNumber, pageSize);
		        return ResponseEntity.ok(getpages);
		    }
	 	
	 	
	 	
}
