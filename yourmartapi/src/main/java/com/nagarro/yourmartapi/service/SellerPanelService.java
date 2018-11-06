/**
 * 
 */
package com.nagarro.yourmartapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nagarro.yourmartapi.entity.CategoryDetails;
import com.nagarro.yourmartapi.entity.ImagePaths;
import com.nagarro.yourmartapi.entity.ProductDetails;
import com.nagarro.yourmartapi.entity.SellerDetails;
import com.nagarro.yourmartapi.repository.CategoryRepository;
import com.nagarro.yourmartapi.repository.ImageRepository;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.repository.SellerRepository;

/**
 * @author ishaanvashishth
 *
 */
@Service
public class SellerPanelService {
	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ImageRepository imageRepo;

	Logger logger = LoggerFactory.getLogger(SellerPanelService.class);
	
	public boolean authenticateSeller(SellerDetails seller) {
		SellerDetails sellerFromDB = null;
		boolean result = false;
		sellerFromDB = this.getSellerById(seller.getSellerId());
		String sha256hexPassword = DigestUtils.sha256Hex(seller.getPassword());
		if(sellerFromDB != null) {
			if(sha256hexPassword.equalsIgnoreCase(sellerFromDB.getPassword()))
				result = true;
		}
		return result;
	}
	
	public SellerDetails registerSeller(SellerDetails seller) {
		return sellerRepo.save(seller);
	}
	
	public SellerDetails getSellerById(Integer id) {
		SellerDetails sellerDetails = sellerRepo.getOne(id);
		logger.info(sellerDetails.toString());
		return sellerRepo.getOne(id);
	}
	
	public ProductDetails getProductById(Integer id) {
		ProductDetails productDetails = productRepo.getOne(id);
		logger.info(productDetails.toString());
		return productDetails;
	}
	
	public Page<ProductDetails> getProductsBySellerId(Integer sellerId, Pageable pageable) {
		return productRepo.findBySellerSellerId(sellerId, pageable);
	}
	
	public ProductDetails addProductForSeller(ProductDetails product) {
		product.setStatus("NEW");
		return productRepo.save(product);
	}
	
	public ArrayList<ImagePaths> addImagesForProduct(ImagePaths[] images) {
		ArrayList<ImagePaths> imagesRes = new ArrayList<>();
		for(ImagePaths image: images) {
			imagesRes.add(imageRepo.save(image));	
		}
		return imagesRes;
	}
	
	public ProductDetails updateProductForSeller(ProductDetails product) {
		product.setStatus("REVIEW");
		return productRepo.save(product);
	}
	
	public List<CategoryDetails> getCategories(){
		return categoryRepo.findAll();
	}
	
	public CategoryDetails getCategoryById(Integer categoryId) {
		return categoryRepo.getOne(categoryId);
	}
	
	public SellerDetails addSeller(SellerDetails seller) {
		seller.setStatus("NEED_APPROVAL");
		String sha256hexPassword = DigestUtils.sha256Hex(seller.getPassword());
		seller.setPassword(sha256hexPassword);
		return sellerRepo.save(seller);
	}
}
