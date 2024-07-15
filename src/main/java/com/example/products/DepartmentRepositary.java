package com.example.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepositary extends JpaRepository<DepartmentEntity,Integer>{

	List<DepartmentEntity> findAll();

}
