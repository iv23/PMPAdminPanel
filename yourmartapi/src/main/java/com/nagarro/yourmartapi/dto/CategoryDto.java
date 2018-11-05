/**
 * 
 */
package com.nagarro.yourmartapi.dto;

import java.util.Set;

/**
 * @author ishaanvashishth
 *
 */
public class CategoryDto {
	private int categoryId;
	private String categoryName;
	private Set<ProductDto> products;
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * 
	 */
	public CategoryDto() {
	}
	/**
	 * @param categoryId
	 * @param categoryName
	 * @param products
	 */
	public CategoryDto(int categoryId, String categoryName, Set<ProductDto> products) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.products = products;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the products
	 */
	public Set<ProductDto> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}
}
