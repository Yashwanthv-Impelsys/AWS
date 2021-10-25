package org.impelsys.employeeservice.service.vo;


import org.impelsys.employeeservice.service.vo.Department;
import org.impelsys.employeeservice.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO {
	
	private Employee employee;
	private Department department;

}
