package com.nagarro.yourmartapi.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.entity.CategoryDetails;
import com.nagarro.yourmartapi.entity.ImagePaths;
import com.nagarro.yourmartapi.entity.ProductDetails;
import com.nagarro.yourmartapi.entity.SellerDetails;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.service.SellerPanelService;
import com.nagarro.yourmartapi.util.ProductPredicatesBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping("/yourmart/sellerapi")
public class SellerPanelController {
	@Autowired
	SellerPanelService sellerService;

	@Autowired
	ProductRepository productsRepository;

	@Autowired
	ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(SellerPanelController.class);

	@PostMapping("/sellers/login")
	public SellerDetails authenticateSeller(@RequestBody SellerDetails seller) {
		boolean result = sellerService.authenticateSeller(seller);
		SellerDetails sellerFromDB = null;
		if (result) {
			sellerFromDB = sellerService.getSellerById(seller.getSellerId());
			logger.info("login success");
		}
		return sellerFromDB;
	}

	@GetMapping("/seller/{sellerId}")
	public SellerDetails getSellerById(@PathVariable(value = "sellerId") Integer sellerId) {
		return sellerService.getSellerById(sellerId);
	}

	@GetMapping("/sellers/{sellerId}/products/{productId}")
	public ProductDetails getProductById(@PathVariable(value = "productId") Integer productId) {
		return sellerService.getProductById(productId);
	}

	@GetMapping(value = "/sellers/{sellerId}/products")
	public Page<ProductDetails> findPaginated(@PathVariable(value = "sellerId") Integer sellerId,
			@RequestParam(value = "search", required=false) String search, Pageable pageable) {
		ProductPredicatesBuilder builder = new ProductPredicatesBuilder();
		if (search != null) {
			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
			Matcher matcher = pattern.matcher(search + ",");
			while (matcher.find()) {
				builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
			}
		}
		BooleanExpression exp = builder.build();
		
		return productsRepository.findAll(exp, pageable);
	}

//	@GetMapping(value = "/sellers/{sellerId}/products/filter")
//	public Page<ProductDetails> findPaginated(@PathVariable(value = "sellerId") Integer sellerId,
//			@RequestParam(value = "search") String search, Pageable pageable) {
//		ProductPredicatesBuilder builder = new ProductPredicatesBuilder();
//		if (search != null) {
//			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
//			Matcher matcher = pattern.matcher(search + ",");
//			while (matcher.find()) {
//				builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
//			}
//		}
//		BooleanExpression exp = builder.build();
//		
//		return productsRepository.findAll(exp, pageable);
//	}

	@PostMapping("/sellers/{sellerId}/products")
	public ProductDetails addProduct(@RequestBody ProductDetails product,@PathVariable(value = "sellerId") Integer sellerId){
		SellerDetails seller = sellerService.getSellerById(sellerId);
		if(product.getSeller()== null)
			product.setSeller(seller);
		else {

			logger.info(product.getSeller().toString());
		}
		return sellerService.addProductForSeller(product);
	}
	
	@PutMapping("/sellers/{sellerId}/products")
	public ProductDetails updateProduct(@RequestBody ProductDetails product){
		return sellerService.updateProductForSeller(product);
	}
	
	@PostMapping("/sellers/{sellerId}/products/{productId}/images")
	public List<ImagePaths> addImagesForProduct(@RequestBody ImagePaths[] images,@PathVariable(value = "productId") Integer productId){
		ProductDetails product = sellerService.getProductById(productId);
		for(ImagePaths image: images) {
			image.setProduct(product);
		}
		return sellerService.addImagesForProduct(images);
	}
	
	@GetMapping("/categories")
	public List<CategoryDetails> getCategories() {
		return sellerService.getCategories();
	}
	
	@GetMapping("/categories/{categoryId}")
	public CategoryDetails getCategoryById(@PathVariable(value="categoryId") Integer categoryId) {
		return sellerService.getCategoryById(categoryId);
	}
	
	@PostMapping("/sellers/register")
	public SellerDetails addSeller(@RequestBody SellerDetails seller) {
		return sellerService.addSeller(seller);
	}
}
