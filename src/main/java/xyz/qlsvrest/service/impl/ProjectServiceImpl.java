package xyz.qlsvrest.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import xyz.qlsvrest.model.Department;
import xyz.qlsvrest.model.Project;

public interface ProjectServiceImpl {
	Project editProject(Integer id, Project project);

	Project deleteProject(Integer id);

	Project getProject(Integer id);

	Project saveProject(Project project);

	List<Project> getProjects();
	
	Page<Project> getProjectPage(int pageNumber, int pageSize);
}
