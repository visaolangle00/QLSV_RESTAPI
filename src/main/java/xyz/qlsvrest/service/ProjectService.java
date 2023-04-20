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
import xyz.qlsvrest.repository.ProjectRepository;
import xyz.qlsvrest.service.impl.ProjectServiceImpl;

@Service
public class ProjectService implements ProjectServiceImpl {
	@Autowired
	private ProjectRepository projectRepository;

	
	
	public ProjectRepository getProjectRepository() {
		return projectRepository;
	}


	public void setProjectRepository(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}


	
	@Override
	public List<Project> getProjects() {
	   List<Project> projects = new ArrayList<>(projectRepository.findAll());
	   return projects;
	}
	

	
	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	
	@Override
	public Project getProject(Integer id){
        return projectRepository.findById(id).orElseThrow();
    }
	
	
	@Override
	public Project deleteProject(Integer id){
        Project project = getProject(id);
        projectRepository.delete(project);
        return project;
    }
	
	
	@Override
	@Transactional
	public Project editProject(Integer id, Project project){
	       Project  projectToEdit = getProject(id);
	       projectToEdit.setName(project.getName());
	       projectToEdit.setCode(project.getCode());
	       
	       if(project.getTeacher()!=null) {
	    	   Teacher teacher = new Teacher();
	    	   projectToEdit.setId(teacher.getId()); 
	       }
	       
	        return projectToEdit;
	    }


	@Override
	public Page<Project> getProjectPage(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Project> projectPage = projectRepository.findAll(pageable);
		return projectPage;
	}
	
	
}
