package com.example.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImp implements DepartmentService 
{

	@Autowired
	private final DepartmentRepositary departmentrepositary;

	public DepartmentServiceImp(DepartmentRepositary departmentrepositary) {
		this.departmentrepositary = departmentrepositary;
	}

	@Override
	public DepartmentEntity createDepartment(DepartmentEntity departmententity) {

		return departmentrepositary.save(departmententity);
	}

	

	@Override
	public List<DepartmentEntity> getAllDepartmentDetails() {

		return departmentrepositary.findAll();
	}

	@Override
	public Optional<DepartmentEntity> getDepartmentById(Integer department_id) {
		
		return departmentrepositary.findById(department_id);
	}
}


