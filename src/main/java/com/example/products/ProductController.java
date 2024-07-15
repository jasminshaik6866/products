package com.example.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productservice;

	// <!--------------Create Product------------------>

	@PostMapping("/product")
	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity ProductEntity) {

		return ResponseEntity.ok().body(this.productservice.createProduct(ProductEntity));

	}

	// <!---------------Get Product- all--------------------------------->

	@GetMapping("/getProduct")
	public ResponseEntity<List<ProductEntity>> getAllProduct() {
		return ResponseEntity.ok().body(this.productservice.getAllProduct());

	}

	// <!-------------------------get product id------------->

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable int id) {
		return ResponseEntity.ok().body(this.productservice.getProductById(id));

	}

	// <!--------------------getProduct ID and Name---------------------------->

	@GetMapping("/product/{id}/{name}")
	public ResponseEntity<ProductEntity> getProductIdByName(@PathVariable int id, @PathVariable String name) {

		ProductEntity products = productservice.getProductIdByName(id, name);
		return ResponseEntity.ok().body(products);

	}

	// <!---------------------Get the Recent created timestamp
	// desc------------------>

	@GetMapping("product/recent")
	public ResponseEntity<List<ProductEntity>> getRecentProduct() {
		List<ProductEntity> products = productservice.getAllProductsByCreatedDateDesc();
		return ResponseEntity.ok().body(products);
	}

	// <--------------------update the data------------------->

	/*
	 * @PutMapping("/products/update") public ResponseEntity<ProductEntity>
	 * updateProduct(@RequestBody ProductEntity productentity) {
	 * 
	 * return
	 * ResponseEntity.ok().body(this.productservice.updateProduct(productentity)); }
	 */

	@PutMapping("/products/{id}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable long id, @RequestBody ProductEntity product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.productservice.updateProduct(product));
	}
	// <!-----------------Delete product--------------------------->

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
		productservice.deleteProductById(id);
		return ResponseEntity.noContent().build(); // Returns HTTP 204 No Content
	}

	// --------------------------JPA-------------------------------

	// <<<<<<<<<<<<<<<<<<<<<<<jpa name starting>>>>>>>>>>full name we have to given
	// in
	// url>>>>>>>>>>>>>>>>>>

	@GetMapping("/productName/{likeName}")
	public ResponseEntity<List<ProductEntity>> getProductByNamestartswith(@PathVariable String likeName) {

		List<ProductEntity> products = productservice.getProductByNamestartswith(likeName);
		return ResponseEntity.ok().body(products);

	}
	// <<<<<<<<<<<<<<<<<<<<<<<jpa name ENDS>>>>>>>>>>full name we have to given in

	// <<<<<URL----http://localhost:8080/product/endWith?name=tv>

	@GetMapping("product/endWith")
	public List<ProductEntity> getProductsByNameEndingWith(@RequestParam String name) {
		return productservice.getProductsByNameEndingWith(name);
	}

	// <<<<<<<<<<<<<<<<<<<<<<<jpa MAX PRISE>>>>>>>>>>>>>>>>>>>>>

	// url --------- http://localhost:8080/product/maxPrice?maxPrice=25000----
	// ---if we have limit to the price upto that we can print --------

	@GetMapping("product/maxPrice")
	public List<ProductEntity> getProductsByMaxPrice(@RequestParam Double maxPrice) {
		return productservice.getProductsByMaxPrice(maxPrice);
	}

	@GetMapping("/maxPriceProductByName")
	public ResponseEntity<ProductEntity> getMaxPriceProductByName(@RequestParam String name) {
		Optional<ProductEntity> product = productservice.findMaxPriceProductByName(name);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/getMaxPrice")
	public ResponseEntity< Optional<Long>> getMaxpriceOnly() {
		 Optional<Long> price = productservice.findByMaxPrice();
		return ResponseEntity.ok().body(price);
	}


}
