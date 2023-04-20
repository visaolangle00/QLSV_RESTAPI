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

import xyz.qlsvrest.dto.StudentDto;
import xyz.qlsvrest.model.Student;
import xyz.qlsvrest.model.Teacher;
import xyz.qlsvrest.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
	//	Company company = companyServiceImpl.saveCompany(Company.from(companyDto));
		Student student = studentService.saveStudent(Student.from(studentDto));
		return new ResponseEntity<StudentDto>(StudentDto.from(student), HttpStatus.OK);
		
	}
		 
	 @GetMapping("/studentss")
	 public ResponseEntity<List<StudentDto>> getStudents() {
		 // List<Project> companies = projectServiceImpl.getAllProjects();
		  
		  List<Student> students = studentService.getStudents();
		  List<StudentDto> studentDtos = new ArrayList<>();
		  
		  for (Student student : students) {
			StudentDto studentDto = new StudentDto();
			studentDtos.add(studentDto);
		}
		  
		return new ResponseEntity<>(studentDtos, HttpStatus.OK);
	    }
	 
	 
	 @GetMapping(value = "{id}")
	 public ResponseEntity<StudentDto> getStudent(@PathVariable final Integer id){
        Student student = studentService.getStudent(id);
        return new ResponseEntity<>(StudentDto.from(student), HttpStatus.OK);
    }
	
	 @DeleteMapping(value = "{id}")
	    public ResponseEntity<StudentDto> deleteStudent(@PathVariable final Integer id){
	        Student student = studentService.deleteStudent(id);
	        return new ResponseEntity<>(StudentDto.from(student), HttpStatus.OK);
	    }
	
	 @PutMapping(value = "{id}")
	    public ResponseEntity<StudentDto> editStudent(@PathVariable final Integer id,
	                                            @RequestBody final  StudentDto studentDto){
	        Student student = studentService.editStudent(id, Student.from(studentDto));
	        return new ResponseEntity<>(StudentDto.from(student), HttpStatus.OK);
	    }
	 
	 @GetMapping
	    public ResponseEntity<Page<Student>> getTeacherPages(
	            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
	            @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
	        Page<Student> getpages = studentService.getStudentPage(pageNumber, pageSize);
	        return ResponseEntity.ok(getpages);
	    }
	 
}
