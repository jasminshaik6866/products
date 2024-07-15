package com.example.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/addEmployee")

	public ResponseEntity<EmployeeEntity> createProduct(@RequestBody EmployeeEntity employeeentity) {

		return ResponseEntity.ok().body(this.employeeService.createProduct(employeeentity));

	}

	@GetMapping("/getEmpDetails")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployeeDetails() {
		return ResponseEntity.ok().body(this.employeeService.getAllEmployeeDetails());

	}
	
	@GetMapping("/getEmpById/{id}")
	public ResponseEntity<EmployeeEntity>getEmployeeById(@PathVariable Long id){
		return ResponseEntity.ok().body(this.employeeService.getEmployeeById(id));
		
	}
	
	 @DeleteMapping("/deleteEmp/{id}")
	    public HttpStatus deleteProduct(@PathVariable long id) {
	        this.employeeService.deleteProduct(id);
	        return HttpStatus.OK;
	    }
}