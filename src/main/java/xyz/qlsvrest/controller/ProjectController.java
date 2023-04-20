package xyz.qlsvrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import xyz.qlsvrest.dto.ProjectDto;
import xyz.qlsvrest.model.Department;
import xyz.qlsvrest.model.Project;
import xyz.qlsvrest.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	
	@PostMapping
	public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto){
	//	Company company = companyServiceImpl.saveCompany(Company.from(companyDto));
		Project project = projectService.saveProject(Project.from(projectDto));
		return new ResponseEntity<ProjectDto>(ProjectDto.from(project), HttpStatus.OK);
		
	}
		 
	 @GetMapping("/projectes")
	 public ResponseEntity<List<ProjectDto>> getAllProjects() {
		  List<Project> companies = projectService.getProjects();
		  List<ProjectDto> projectDtos = new ArrayList<>();
		  for (Project project : companies) {
			ProjectDto projectDto = new ProjectDto();
			projectDtos.add(projectDto);
		}
		return new ResponseEntity<>(projectDtos, HttpStatus.OK);
	    }
	 
	 
	 @GetMapping(value = "{id}")
	 public ResponseEntity<ProjectDto> getProject(@PathVariable final Integer id){
        Project project = projectService.getProject(id);
        return new ResponseEntity<>(ProjectDto.from(project), HttpStatus.OK);
    }
	
	 @DeleteMapping(value = "{id}")
	    public ResponseEntity<ProjectDto> deleteProject(@PathVariable final Integer id){
	        Project project = projectService.deleteProject(id);
	        return new ResponseEntity<>(ProjectDto.from(project), HttpStatus.OK);
	    }
	
	 @PutMapping(value = "{id}")
	    public ResponseEntity<ProjectDto> editProject(@PathVariable final Integer id,
	                                            @RequestBody final  ProjectDto projectDto){
	        Project editProject = projectService.editProject(id, Project.from(projectDto));
	        return new ResponseEntity<>(ProjectDto.from(editProject), HttpStatus.OK);
	    }
	 
	 @GetMapping
	    public ResponseEntity<Page<Project>> getProjectPages(
	            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
	            @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
	        Page<Project> getpages = projectService.getProjectPage(pageNumber, pageSize);
	        return ResponseEntity.ok(getpages);
	    }
	 
	 
}
