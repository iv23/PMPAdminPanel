/**
 * 
 */
package com.nagarro.yourmartapi.dto;

/**
 * @author ishaanvashishth
 *
 */
public class ProductAttribuesDto {
	private int productAttrId;
	private String productAttrKey;
	private String productAttrValue;
	private ProductDto product;
	/**
	 * @return the productAttrId
	 */
	public int getProductAttrId() {
		return productAttrId;
	}
	/**
	 * @param productAttrId the productAttrId to set
	 */
	public void setProductAttrId(int productAttrId) {
		this.productAttrId = productAttrId;
	}
	/**
	 * @return the productAttrKey
	 */
	public String getProductAttrKey() {
		return productAttrKey;
	}
	/**
	 * @param productAttrKey the productAttrKey to set
	 */
	public void setProductAttrKey(String productAttrKey) {
		this.productAttrKey = productAttrKey;
	}
	/**
	 * @return the productAttrValue
	 */
	public String getProductAttrValue() {
		return productAttrValue;
	}
	/**
	 * @param productAttrValue the productAttrValue to set
	 */
	public void setProductAttrValue(String productAttrValue) {
		this.productAttrValue = productAttrValue;
	}
	/**
	 * @return the product
	 */
	public ProductDto getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	/**
	 * 
	 */
	public ProductAttribuesDto() {
	}
	/**
	 * @param productAttrId
	 * @param productAttrKey
	 * @param productAttrValue
	 * @param product
	 */
	public ProductAttribuesDto(int productAttrId, String productAttrKey, String productAttrValue, ProductDto product) {
		this.productAttrId = productAttrId;
		this.productAttrKey = productAttrKey;
		this.productAttrValue = productAttrValue;
		this.product = product;
	}
	
}
