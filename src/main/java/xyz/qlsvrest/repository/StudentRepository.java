package xyz.qlsvrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.qlsvrest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
