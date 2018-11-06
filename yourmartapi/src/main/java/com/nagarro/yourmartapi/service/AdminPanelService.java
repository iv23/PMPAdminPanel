package com.nagarro.yourmartapi.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nagarro.yourmartapi.entity.AdminUserDetails;
import com.nagarro.yourmartapi.entity.CategoryDetails;
import com.nagarro.yourmartapi.entity.ProductDetails;
import com.nagarro.yourmartapi.entity.SellerDetails;
import com.nagarro.yourmartapi.repository.AdminUserRepository;
import com.nagarro.yourmartapi.repository.CategoryRepository;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.repository.SellerRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class AdminPanelService {
	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	AdminUserRepository adminUserRepo;
	
	Logger logger = LoggerFactory.getLogger(AdminPanelService.class);
	
	public boolean authenticateAdminUser(AdminUserDetails adminUser) {
		AdminUserDetails adminUserFromDB = null;
		boolean result = false;
		logger.info(adminUserRepo.findByYourmartId(adminUser.getYourmartId()).toString());
		adminUserFromDB = adminUserRepo.findByYourmartId(adminUser.getYourmartId());
		String sha256hexPassword = DigestUtils.sha256Hex(adminUser.getPassword());
		if(adminUserFromDB != null) {
			if(sha256hexPassword.equalsIgnoreCase(adminUserFromDB.getPassword()))
				result = true;
			else
				result = false;
		}
		return result;
	}
	
	public Page<SellerDetails> getAllSellers(Pageable pageable) {
		return sellerRepo.findAll(pageable);
	}
	
	public Page<SellerDetails> getAllSellersPageable(Pageable pageable) {
		return sellerRepo.findAll(pageable);
	}
	
	public Page<SellerDetails> getAllSellersPageableAndFiltered(Pageable pageable, BooleanExpression exp) {
		return sellerRepo.findAll(exp, pageable);
	}
	
	public Page<ProductDetails> getAllProductsPageable(Pageable pageable) {
		return productRepo.findAll(pageable);
	}
	
	public Page<ProductDetails> getAllProductsPageableAndFiltered(Pageable pageable, BooleanExpression exp) {
		return productRepo.findAll(exp, pageable);
	}
	
	public List<ProductDetails> getAllProducts(Pageable pageable) {
		return productRepo.findAll(pageable).getContent();
	}
	
	public ProductDetails getProductById(Integer productId) {
		
		return productRepo.getOne(productId);
	}
	
	public CategoryDetails addCategory(CategoryDetails category) {
		return categoryRepo.save(category);
	}
	
	public CategoryDetails getCategory(int categoryId) {
		return categoryRepo.getOne(categoryId);
	}
	
	public boolean deleteCategory(int categoryId) {
		boolean result = false;
		if(this.getCategory(categoryId).getProducts()==null) {
			categoryRepo.deleteById(categoryId);
			result = true;
		}
		return result;
	}
	
	public List<CategoryDetails> getCategories() {
		return categoryRepo.findAll();
	}

	public void editCategory(int categoryId, String newName) {
		CategoryDetails category = new CategoryDetails();
		category.setCategoryId(categoryId);
		category.setCategoryName(newName);
		this.addCategory(category);
	}

	public SellerDetails getSellerById(int sellerId) {
		return sellerRepo.getOne(sellerId);
	}

	public void approve(String[] selectedSeller) {
		SellerDetails selectedSellerObj = null;
		for(String selected: selectedSeller) {
			int selectedID = Integer.parseInt(selected);
			selectedSellerObj = this.sellerRepo.getOne(selectedID);
			selectedSellerObj.setStatus("APPROVED");
			this.sellerRepo.save(selectedSellerObj);
		}
		
	}

	public void reject(String[] selectedSeller) {
		SellerDetails selectedSellerObj = null;
		for(String selected: selectedSeller) {
			int selectedID = Integer.parseInt(selected);
			selectedSellerObj = this.sellerRepo.getOne(selectedID);
			selectedSellerObj.setStatus("REJECTED");
			this.sellerRepo.save(selectedSellerObj);
		}
	}

}
