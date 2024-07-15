package com.example.products;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;


public class EmployeeServiceImpl implements EmployeeService {
	
	 @Autowired
	  private final EmployeeRepositary employeeRepository;

	   
	    public EmployeeServiceImpl(EmployeeRepositary employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }

	
	
	  public EmployeeEntity createProduct(EmployeeEntity employeeentity) 
	  {
		  return employeeRepository.save(employeeentity); }



	public List<EmployeeEntity> getAllEmployeeDetails() {
		 List<EmployeeEntity>  lessthan5oksalList = null;
		
		List<EmployeeEntity> response =  employeeRepository.findAll();
		
		for(EmployeeEntity obj : response) {
			if(obj.getSalary() > 30000 && obj.getSalary() < 50000) {
				lessthan5oksalList.add(obj);
			}
		}
		
		// java 8
		List output = response.stream().filter( s-> s.getSalary()  > 30000 && s.getSalary() < 50000 ).collect(Collectors.toList());
		
		return output;
		
		//
	}



	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		
		Optional<EmployeeEntity> employee= employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
			
		}else {
		 throw new ResourceNotFoundException("Recored not found wth the id :" + id);
		}
		}

		/*
		 * public void deleteProduct(long id) { Optional < EmployeeEntity > productDb =
		 * this.employeeRepository.findById(id);
		 * 
		 * if (productDb.isPresent()) { this.employeeRepository.delete(productDb.get());
		 * } else { throw new ResourceNotFoundException("Record not found with id : " +
		 * id); } }
		 */
	


	@Override
	public void deleteProduct(long id) {
		
		 employeeRepository.deleteById(id);
		
	}



	
	}





	


	
	 

