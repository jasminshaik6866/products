package com.example.products;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
	;

	EmployeeEntity createProduct(EmployeeEntity employeeentity);

	public List<EmployeeEntity> getAllEmployeeDetails();

	EmployeeEntity getEmployeeById(Long id);

	void deleteProduct(long id);

}
