package com.democrud;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.democrud.entity.Employee;
import com.democrud.repository.EmployeeRepository;

@SpringBootTest
class DemocrudApplicationTests {

	@Autowired
	private EmployeeRepository er;
	@Test
	void saveEmployee() {
		Employee e1=new Employee();
		e1.setName("Sam");
		e1.setEmail("sam@gmail.com");
		e1.setMobile("9956232166");
		er.save(e1);
	}
	
	@Test
	void getEmp() {
		Optional<Employee> emp=er.findById(1);
		if(emp.isPresent()) {
			System.out.println(emp.get().getName());
		}else {
			System.out.println("No Employee found");
		}
	}
	
	@Test
	void getEmps() {
		Iterable<Employee> emp=er.findAll();
		for(Employee e:emp) {
			if(e!=null) {
			System.out.println(e.getName());
		}else {
			System.out.println("No Employee found");
		}
		}
	}
	
	@Test
	void deleteEmp() {
		er.deleteById(3);
	}
	
	@Test
	void getEmpByName() {
		Optional<Employee> emp=er.findEmployeeByName("adam");
		if(emp.isPresent()) {
			System.out.println(emp.get().getName());
			System.out.println(emp.get().getEmail());
			System.out.println(emp.get().getMobile());
		}else {
			System.out.println("No Employee found");
		}
	}
	@Test
	void getEmpByEmail() {
		Optional<Employee> emp=er.findEmployeeByEmail("mike@gmail.com");
		if(emp.isPresent()) {
			System.out.println(emp.get().getName());
			System.out.println(emp.get().getEmail());
			System.out.println(emp.get().getMobile());
		}else {
			System.out.println("No Employee found");
		}
	}
	@Test
	void getEmpNameStatingWith() {
		Optional<Employee> emp=er.findEmployeeByNameStartingWith("m");
		if(emp.isPresent()) {
			System.out.println(emp.get().getName());
			System.out.println(emp.get().getEmail());
			System.out.println(emp.get().getMobile());
		}else {
			System.out.println("No Employee found");
		}
	}
	
	@Test
	void getEmpNameEndingWith() {
		Optional<Employee> emp=er.findEmployeeByNameEndingWith("m");
		if(emp.isPresent()) {
			System.out.println(emp.get().getName());
			System.out.println(emp.get().getEmail());
			System.out.println(emp.get().getMobile());
		}else {
			System.out.println("No Employee found");
		}
	}
	@Test
	void getEmpNameContaing() {
		List <Employee> emp=er.findByNameContaining("m");
		for(Employee e:emp) {
		if(e!=null) {
			System.out.println(e.getName());
			System.out.println(e.getEmail());
			System.out.println(e.getMobile());
		}else {
			System.out.println("No Employee found");
		}
		}
	}
	

}
