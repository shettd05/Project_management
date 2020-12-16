package com.jrp.pma.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects (Model model) {
		List<Project> projectList = proRepo.findAll();
		model.addAttribute("project", projectList);
		return "projects/project-list";
	}
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		List<Employee> empList = empRepo.findAll();
		model.addAttribute("allemployees", empList);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project,Model moldel,@RequestParam List<Long> employees) {
		proRepo.save(project);
		return "redirect:/projects/new";
	}
}
