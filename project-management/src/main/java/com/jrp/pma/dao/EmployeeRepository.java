package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.project_id) as projectCount "
			+ "FROM employee e LEFT JOIN project_employee  pe ON e.employee_id = pe.employee_id "
			+ "GROUP BY first_name, last_name "
			+ "ORDER BY 3  desc;")
	public List<EmployeeProject> employeeProjectCount();
	

}
