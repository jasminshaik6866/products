package com.example.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositary extends JpaRepository<ProductEntity, Integer> {

	ProductEntity findByIdAndName(int id, String name);

	List<ProductEntity> findAllByOrderByCreatedAtDesc();

	Optional<ProductEntity> findById(long id);

//	List<ProductEntity> findByNameStartingWith(String name);

	@Query("select e from ProductEntity e where e.name like %:name")
	List<ProductEntity> findByNameStartingWith(@Param("name") String name);
	
	

	@Query("select e from ProductEntity e where e.name like %:name")
	List<ProductEntity> findByNameEndingWith(String name);	
	
	

	List<ProductEntity> findByPriceLessThanEqual(Double maxPrice);
	
	 Optional<ProductEntity> findTopPriceByOrderByPriceDesc(); 
	 
	 @Query(value = "SELECT MAX(price) FROM Product", nativeQuery = true)
	    Optional<Long> findTopSalaryNative();
	

	/*
	 * @Query("SELECT p FROM ProductEntity p WHERE p.name = :name AND p.price = (SELECT MAX(p2.price) FROM ProductEntity p2 WHERE p2.name = :name)"
	 * ) Optional<ProductEntity> findMaxPriceProductByName(@Param("name") String
	 * name);
	 */
	
	@Query("SELECT p FROM ProductEntity p WHERE LOWER(p.name) = LOWER(:name) AND p.price = (SELECT MAX(p2.price) FROM ProductEntity p2 WHERE LOWER(p2.name) = LOWER(:name))")
    Optional<ProductEntity> findMaxPriceProductByName(@Param("name") String name);


	
	
	
}
