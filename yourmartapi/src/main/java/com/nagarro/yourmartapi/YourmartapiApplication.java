package com.nagarro.yourmartapi;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.nagarro.yourmartapi.entity.AddressDetails;
import com.nagarro.yourmartapi.entity.SellerDetails;
import com.nagarro.yourmartapi.property.FileStorageProperties;
import com.nagarro.yourmartapi.repository.AdminUserRepository;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.repository.SellerRepository;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class YourmartapiApplication implements CommandLineRunner{
	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	AdminUserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(YourmartapiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(YourmartapiApplication.class, args);
		
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		ProductPredicate spec = new ProductPredicate(new SearchCriteria("productCode",SearchOperation.CONTAINS,"abc"));
//		ProductPredicatesBuilder builder = new ProductPredicatesBuilder().with("productCode", ":", "abc"); 
//		Iterable<ProductDetails> products = productRepository.findAll(builder.build());
//		for(ProductDetails product:products) {
//			logger.info(product.toString());
//		}
//		List<ProductDto> productsDto = products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
//		for(ProductDto product: productsDto) {
//			logger.info(product.toString());
//		}
//		logger.info(DigestUtils.sha256Hex("quertyui"));
//		UserDetails user = new UserDetails();
//		user.setEmail("ishaan.vashishth@nagarro.com");
//		user.setYourmartId("admin1");
//		user.setPassword(bCryptPasswordEncoder.encode("qwertyui"));
//		user.setEnabled(1);
//		RoleDetails role1 = roleRepository.findByRole("ADMIN");
//		user.setRole(role1);
//		userRepository.save(user);
//		UserDetails user2 = new UserDetails();
//		user2.setEmail("ishaanvashishth@gmail.com");
//		user2.setYourmartId("admin2");
//		user2.setPassword(bCryptPasswordEncoder.encode("qwertyui"));
//		user2.setEnabled(1);
//		user2.setRole(role1);
//		userRepository.save(user2);
//		SellerDetails seller = new SellerDetails();
//		AddressDetails address = new AddressDetails("B7-10, First floor", "Double Storey", "Ramesh Nagar", "New Delhi", "India", "110015");
//		ProductDetails product = new ProductDetails("newPro", "asdas", "abc", 123, 123, 123, "abc", "abc", "abc", "abc", "abc");
//		ProductAttributes productAttributes = new ProductAttributes();
//		productAttributes.setProductAttrKey("asda");
//		productAttributes.setProductAttrValue("asda");
//		ProductAttributes productAttributes2 = new ProductAttributes();
//		productAttributes2.setProductAttrKey("asdaasd");
//		productAttributes2.setProductAttrValue("asdaasda");
//		ImagePaths imagePaths = new ImagePaths();
//		imagePaths.setImagePath("sdasf");
//		ImagePaths imagePaths2 = new ImagePaths();
//		imagePaths2.setImagePath("sdasdasf");
//		Optional<CategoryDetails> categories = categoryRepository.findById(1);
//		logger.info(categories.get().toString());
//		Optional<CategoryDetails> categories2 = categoryRepository.findById(2);
//		logger.info(categories2.get().toString());
//		seller.setAddress(address);
//		seller.setCompanyName("Linen and Laces");
//		seller.setGstNumber("safasf21341");
//		seller.setOwnerName("Ishaan");
//		seller.setPassword("a17444550e2c127b02ea1c197bcffa422c21713040f53d5c2ca7925419bccf7f");
//		seller.setTelephone("8800355378");
//		seller.setEmail("ishaanvashishth@gmail.com");
//		sellerRepository.save(seller);
//		product.setSeller(sellerRepository.getOne(10001));
//		productAttributes.setProduct(product);
//		productAttributes2.setProduct(product);
//		imagePaths.setProduct(product);
//		imagePaths2.setProduct(product);
//		product.getProductAttributes().add(productAttributes);
//		product.getProductAttributes().add(productAttributes2);
//		product.getImagePaths().add(imagePaths);
//		product.getImagePaths().add(imagePaths2);
//		product.addCategory(categories.get());
//		product.addCategory(categories2.get());
//		productRepository.save(product);
		
	}
	
}
