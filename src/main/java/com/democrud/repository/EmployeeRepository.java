package com.democrud.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.democrud.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	Optional<Employee> findEmployeeByEmail(String email);
	Optional<Employee> findEmployeeByName(String email);
	Optional<Employee> findEmployeeByNameStartingWith(String prefix);
	Optional<Employee> findEmployeeByNameEndingWith(String prefix);
	List<Employee> findByNameContaining(String contain);
	
	@Query("select e from Employee e where e.email=:x")
	Optional<Employee> searchEmployeeByEmail(@Param("x") String email);
	
	@Query("select e from Employee e where e.email=:x and e.name=:y")
	Optional<Employee> searchEmployeeByEmailAndName(@Param("x") String email,@Param("y") String name);
	
	@Query(value="select * from employees where email=?1",nativeQuery = true)
	Optional<Employee> searchEmployeeByEmailsql(String email);
	
	@Query(value="select * from employees where email=?1 or name=?2",nativeQuery = true)
	List <Employee> searchEmployeeByEmailOrNameSQL(String email,String name);
	
}
