package com.example.products;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImp implements ProductService

{
	@Autowired
	private ProductRepositary productrepositary;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);

	// <<<<<<<<<<<<<<<<<<<<Create product>>>>>>>>>>>>>>>>>>>>>

	@Override
	public ProductEntity createProduct(ProductEntity productentity) {
		logger.info("createProduct {}" + productentity);
		return productrepositary.save(productentity);

	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<GetAll>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<ProductEntity> getAllProduct() {
		logger.info("Fetching all products");
		return this.productrepositary.findAll();
	}

	// <<<<<<<<<<<<<<<<<<<<<<<< Get Product Id>>>>>>>>>>>>>>>>>>>>>

	@Override
	public ProductEntity getProductById(int id) {
		logger.info("Fetching product by id: {}", id);

		Optional<ProductEntity> productDB = this.productrepositary.findById(id);
		if (productDB.isPresent()) {

			logger.info("Product found: {}", productDB.get());

			return productDB.get();
		} else {
			logger.error("Product not found with id: {}", id);
			throw new ResourceNotFoundException("Recored not found wth the id :" + id);
		}

	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<Get Id and Name>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public ProductEntity getProductIdByName(int id, String name) {
		logger.info("Fetching product by id: {} and name: {}", id, name);

		return productrepositary.findByIdAndName(id, name);
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<resent date products>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<ProductEntity> getAllProductsByCreatedDateDesc() {

		logger.info("Fetching all products by created date in descending order");

		return productrepositary.findAllByOrderByCreatedAtDesc();
	}

	@Override
	public Optional<ProductEntity> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	// <<<<<<<<<<<<<<<<<<<<<<<Update the
	// product.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        Optional < ProductEntity > productDb = this.productrepositary.findById(product.getId());

        if (productDb.isPresent()) {
        	ProductEntity productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productrepositary.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }
	
	// <<<<<<<<<<<<<<<<<<<<<<<<Delete product>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void deleteProductById(long id) 
	{
		  logger.info("Deleting product with id: {}", id);
		  
		ProductEntity existingProduct = productrepositary.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
		productrepositary.delete(existingProduct);
		  logger.info("Deleted product with id: {}", id);

	}
	
	//<<<<<<<<<<<<<<<<     NameStartsWith            >>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<ProductEntity> getProductByNamestartswith(String likeName) {
		System.out.println("im in service impl - getProductByNamestartswith :"+ likeName);
		return productrepositary.findByNameStartingWith(likeName);
	}
	//<<<<<<<<<<<<<<<<     NameEndsWith            >>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<ProductEntity> getProductsByNameEndingWith(String name) {
		System.out.println("im in service impl - getProductByNameedswith :"+ name);
		return productrepositary.findByNameEndingWith(name);
	}
	 @Override
	    public List<ProductEntity> getProductsByMaxPrice(Double maxPrice) {
	        return productrepositary.findByPriceLessThanEqual(maxPrice);
	    }

	 @Override
	    public Optional<ProductEntity> findMaxPriceProductByName(String name) {
	        return productrepositary.findMaxPriceProductByName(name);
	    }

	@Override
	public Optional<ProductEntity> getPriceListDesc() {
		// TODO Auto-generated method stub
		   return productrepositary.findTopPriceByOrderByPriceDesc();
	}

	@Override
	public Optional<Long> findByMaxPrice() {
		// TODO Auto-generated method stub
		
		
		return productrepositary.findTopSalaryNative();
	}

	

	
	
	


}
