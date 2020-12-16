package com.jrp.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
//	EmployeeRepository empRepoConstructoInjection;
//	EmployeeRepository empRepoSetterIjection;
//	
//	@Autowired  // field dependency injection
//	EmployeeRepository empRepofeildInjection;
//	
//	public EmployeeServices(EmployeeRepository empRepoConstructoInjection) {
//		// TODO Auto-generated constructor stub
//		super();
//		this.empRepoConstructoInjection = empRepoConstructoInjection;
//	}
//
//	
//	@Autowired
//	public void setEmpRepoSetterIjection(EmployeeRepository empRepoSetterIjection) {
//		this.empRepoSetterIjection = empRepoSetterIjection;
//	}
//	
	IstaffRepository iStffRepo;

	@Autowired
	public void setiStffRepo(@Qualifier("staffReposistoryImplementation2") IstaffRepository iStffRepo) {
		this.iStffRepo = iStffRepo;
	}
	
	
	 
	
	
}
