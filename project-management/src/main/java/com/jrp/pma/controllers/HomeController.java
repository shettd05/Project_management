package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ProjectCount;
import com.jrp.pma.entities.Project;
import com.jrp.pma.examples.Car;

@Controller
public class HomeController {
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectRepository prjRepo;
	
	
	EmployeeRepository empRepo;
	
	@Autowired
	public void setEmpRepo(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Autowired
	Car car;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		model.addAttribute("version", ver);
		
		List<ProjectCount> projectCountList =  prjRepo.projectStageCount();
		model.addAttribute("projectCountList", projectCountList);
		List<EmployeeProject> empProjectList = empRepo.employeeProjectCount();
		model.addAttribute("empProjectList", empProjectList);
		
		List<Project> projectList = prjRepo.findAll();
		model.addAttribute("projectList", projectList);
		//Converting empProjectList object to JSON format
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectCountList);
		
		model.addAttribute("proectStatusCount", jsonString);
		
		
		return "Home/Home";
	}
}
