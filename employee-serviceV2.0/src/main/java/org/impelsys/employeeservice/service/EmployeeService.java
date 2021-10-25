package org.impelsys.employeeservice.service;

import java.util.Optional;

import org.impelsys.employeeservice.model.Employee;
import org.impelsys.employeeservice.repository.EmployeeRepository;
import org.impelsys.employeeservice.service.vo.Department;
import org.impelsys.employeeservice.service.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmployeeService {
	@Value("${deptservice_endpoint}")
	String deptServiceEndPoint;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EmployeeRepository empRepo;

	public Employee saveEmployee(Employee dept) {
		// TODO Auto-generated method stub
		return empRepo.save(dept);
		
	}

	public Employee findEmployeeById(Integer id) {
		return empRepo.getById(id);
	}
	
	public Optional<Employee> findEmployeeById2(Integer id) {
		return empRepo.findById(id);
	}
	
	public ResponseVO findEmployeeWithDeptById(Integer id){
		ResponseVO responseVO= new ResponseVO();
		Employee emp= empRepo.findById(id).get();
		//need to call different microservice department
		
		ResponseEntity<Department> deptResponse=restTemplate.getForEntity(deptServiceEndPoint+emp.getDeptId(),Department.class);
		log.info("deptResponse:"+deptResponse);
		responseVO.setEmployee(emp);
		responseVO.setDepartment(deptResponse.getBody());
		
		return responseVO;
		
	}
}