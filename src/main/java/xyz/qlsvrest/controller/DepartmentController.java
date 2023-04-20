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

import xyz.qlsvrest.dto.DepartmentDto;
import xyz.qlsvrest.model.Company;
import xyz.qlsvrest.model.Department;
import xyz.qlsvrest.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveCompany(@RequestBody DepartmentDto departmentDto){
	//	Company company = companyServiceImpl.saveCompany(Company.from(companyDto));
		Department department = departmentService.saveDepartment(Department.from(departmentDto));
		return new ResponseEntity<>(DepartmentDto.from(department), HttpStatus.OK);
		
		
	}
	
	
	 @GetMapping("/departmentes")
	 public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
		  List<Department> departments = departmentService.getDepartments();
		  List<DepartmentDto> departmentDtos = new ArrayList<>();
		  for (Department department : departments) {
			DepartmentDto departmentDto = DepartmentDto.from(department);
			departmentDtos.add(departmentDto);
		}
		 
		return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
	    }
	 
	 
	 @GetMapping(value = "{id}")
	 public ResponseEntity<DepartmentDto> getDepartment(@PathVariable final Integer id){
        Department department = departmentService.getDepartment(id);
        return new ResponseEntity<>(DepartmentDto.from(department), HttpStatus.OK);
    }
	
	 @DeleteMapping(value = "{id}")
	    public ResponseEntity<DepartmentDto> deleteDepartment(@PathVariable final Integer id){
	        Department department = departmentService.deleteDepartment(id);
	        return new ResponseEntity<>(DepartmentDto.from(department), HttpStatus.OK);
	    }
	
	 @PutMapping(value = "{id}")
	    public ResponseEntity<DepartmentDto> editDepart(@PathVariable final Integer id,
	                                            @RequestBody final DepartmentDto departmentDto){
	        Department editDepartment = departmentService.editDepartment(id, Department.from(departmentDto));
	        return new ResponseEntity<>(DepartmentDto.from(editDepartment), HttpStatus.OK);
	    }
	 
	 @GetMapping
	    public ResponseEntity<Page<Department>> getDepartmentPages(
	            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
	            @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
	        Page<Department> getpages = departmentService.getDepartmentPage(pageNumber, pageSize);
	        return ResponseEntity.ok(getpages);
	    }
	 
	 
}
