package xyz.qlsvrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.qlsvrest.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
