package xyz.qlsvrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.qlsvrest.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
