package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping
	public String showEmployees(Model model) {
		
		List<Employee> employeeList = emprepo.findAll();
		model.addAttribute("employeeList", employeeList);
		
		return "Employees/employee-list";
	}
	
	
	@GetMapping("/new")
	public String employeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "Employees/new-employee";
	}
	
	@PostMapping("/save")
	public String employeeSave(Employee emp,Model model) {
		
		emprepo.save(emp);
		return "redirect:/employee/new";
	}
}
