package xyz.qlsvrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.qlsvrest.model.Company;


public interface CompanyRepository extends JpaRepository<Company, Integer> {
	  List<Company> findByNameEndingWith(String ending);
}
