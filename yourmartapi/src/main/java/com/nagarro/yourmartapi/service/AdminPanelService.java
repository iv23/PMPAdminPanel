package com.nagarro.yourmartapi.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nagarro.yourmartapi.entity.AdminUserDetails;
import com.nagarro.yourmartapi.entity.ProductDetails;
import com.nagarro.yourmartapi.entity.SellerDetails;
import com.nagarro.yourmartapi.repository.AdminUserRepository;
import com.nagarro.yourmartapi.repository.CategoryRepository;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.repository.SellerRepository;

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
	
	public boolean authenticateAdminUser(AdminUserDetails adminUser) {
		AdminUserDetails adminUserFromDB = null;
		boolean result = false;
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
	
	public List<SellerDetails> getAllSellers(Pageable pageable) {
		return sellerRepo.findAll(pageable).getContent();
	}
	
	public List<ProductDetails> getAllProducts(Pageable pageable) {
		return productRepo.findAll(pageable).getContent();
	}
}
