package com.example.products;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

	ProductEntity createProduct(ProductEntity productentity); // create

	List<ProductEntity> getAllProduct(); // get all product

	ProductEntity getProductById(int id); // get by id

	ProductEntity getProductIdByName(int id, String name);

	List<ProductEntity> getAllProductsByCreatedDateDesc();

	Optional<ProductEntity> findById(long id);

	ProductEntity updateProduct(ProductEntity productentity);

	void deleteProductById(long id);

	List<ProductEntity> getProductByNamestartswith(String likeName);

	List<ProductEntity> getProductsByNameEndingWith(String name);

	List<ProductEntity> getProductsByMaxPrice(Double maxPrice);

	Optional<ProductEntity> findMaxPriceProductByName(String name);

	Optional<ProductEntity> getPriceListDesc();

	 Optional<Long> findByMaxPrice();

}
