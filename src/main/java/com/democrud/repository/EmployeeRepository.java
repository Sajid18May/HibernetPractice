package com.democrud.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.democrud.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	Optional<Employee> findEmployeeByEmail(String email);
	Optional<Employee> findEmployeeByName(String email);
	Optional<Employee> findEmployeeByNameStartingWith(String prefix);
	Optional<Employee> findEmployeeByNameEndingWith(String prefix);
	List<Employee> findByNameContaining(String contain);
}
