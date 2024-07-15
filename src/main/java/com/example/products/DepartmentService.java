package com.example.products;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

	DepartmentEntity createDepartment(DepartmentEntity departmententity);

	

	List<DepartmentEntity> getAllDepartmentDetails();



	Optional<DepartmentEntity> getDepartmentById(Integer department_id);



	
}
