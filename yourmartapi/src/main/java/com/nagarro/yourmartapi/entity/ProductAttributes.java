/**
 * 
 */
package com.nagarro.yourmartapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ishaanvashishth
 *
 */
@Entity(name = "product_attributes")
@Table(name = "product_attributes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductAttributes {
	@Id
	@Column(name = "product_attr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productAttrId;
	
	/**
	 * 
	 */
	public ProductAttributes() {
	}

	@Column(name="product_attr_key")
	private String productAttrKey;
	
	@Column(name="product_attr_value")
	private String productAttrValue;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private ProductDetails product;

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
	public ProductDetails getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductDetails product) {
		this.product = product;
	}

}
