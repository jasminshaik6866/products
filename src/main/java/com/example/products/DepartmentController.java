package com.example.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentservice;

	public DepartmentController(DepartmentService departmentservice) {
		this.departmentservice = departmentservice;

	}

	@PostMapping("/addDepartment")
	public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity departmententity) {

		return ResponseEntity.ok().body(this.departmentservice.createDepartment(departmententity));

	}

	@GetMapping("/getDeptDetails")
	public ResponseEntity<List<DepartmentEntity>> getAllDepartmentDetails() {
		return ResponseEntity.ok().body(this.departmentservice.getAllDepartmentDetails());

	}

	@GetMapping("/getdepartmentid/{department_id}")
	public ResponseEntity<Optional<DepartmentEntity>> getDepartmentById(@PathVariable Integer department_id) {
		return ResponseEntity.ok().body(this.departmentservice.getDepartmentById(department_id));

	}


}
