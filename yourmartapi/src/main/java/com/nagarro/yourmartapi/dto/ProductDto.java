/**
 * 
 */
package com.nagarro.yourmartapi.dto;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author ishaanvashishth
 *
 */
public class ProductDto {
	
	
	private int productId;
	private String productCode;
	private String productName;
	private String status;
	private double mrp;
	private double ssp;
	private double ymp;
	private String primaryImagePath;
	private String shortDescription;
	private String longDescription;
	private String dimensions;
	private SellerDto seller;
	private String comment;
	private Set<CategoryDto> categories;
	private Set<ProductAttribuesDto> productAttributes;
	private Set<ImagePathsDto> imagePaths;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the mrp
	 */
	public double getMrp() {
		return mrp;
	}
	/**
	 * @param mrp the mrp to set
	 */
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	/**
	 * @return the ssp
	 */
	public double getSsp() {
		return ssp;
	}
	/**
	 * @param ssp the ssp to set
	 */
	public void setSsp(double ssp) {
		this.ssp = ssp;
	}
	/**
	 * @return the ymp
	 */
	public double getYmp() {
		return ymp;
	}
	/**
	 * @param ymp the ymp to set
	 */
	public void setYmp(double ymp) {
		this.ymp = ymp;
	}
	/**
	 * @return the primaryImagePath
	 */
	public String getPrimaryImagePath() {
		return primaryImagePath;
	}
	/**
	 * @param primaryImagePath the primaryImagePath to set
	 */
	public void setPrimaryImagePath(String primaryImagePath) {
		this.primaryImagePath = primaryImagePath;
	}
	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}
	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	/**
	 * @return the longDescription
	 */
	public String getLongDescription() {
		return longDescription;
	}
	/**
	 * @param longDescription the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	/**
	 * @return the dimensions
	 */
	public String getDimensions() {
		return dimensions;
	}
	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	/**
	 * @return the seller
	 */
	public SellerDto getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(SellerDto seller) {
		this.seller = seller;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the categories
	 */
	public Set<CategoryDto> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Set<CategoryDto> categories) {
		this.categories = categories;
	}
	/**
	 * @return the productAttributes
	 */
	public Set<ProductAttribuesDto> getProductAttributes() {
		return productAttributes;
	}
	/**
	 * @param productAttributes the productAttributes to set
	 */
	public void setProductAttributes(Set<ProductAttribuesDto> productAttributes) {
		this.productAttributes = productAttributes;
	}
	/**
	 * @return the imagePaths
	 */
	public Set<ImagePathsDto> getImagePaths() {
		return imagePaths;
	}
	/**
	 * @param imagePaths the imagePaths to set
	 */
	public void setImagePaths(Set<ImagePathsDto> imagePaths) {
		this.imagePaths = imagePaths;
	}
	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * @param productId
	 * @param productCode
	 * @param productName
	 * @param status
	 * @param mrp
	 * @param ssp
	 * @param ymp
	 * @param primaryImagePath
	 * @param shortDescription
	 * @param longDescription
	 * @param dimensions
	 * @param seller
	 * @param comment
	 * @param categories
	 * @param productAttributes
	 * @param imagePaths
	 * @param createdAt
	 * @param updatedAt
	 */
	public ProductDto(int productId, String productCode, String productName, String status, double mrp, double ssp,
			double ymp, String primaryImagePath, String shortDescription, String longDescription, String dimensions,
			SellerDto seller, String comment, Set<CategoryDto> categories, Set<ProductAttribuesDto> productAttributes,
			Set<ImagePathsDto> imagePaths, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.status = status;
		this.mrp = mrp;
		this.ssp = ssp;
		this.ymp = ymp;
		this.primaryImagePath = primaryImagePath;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.dimensions = dimensions;
		this.seller = seller;
		this.comment = comment;
		this.categories = categories;
		this.productAttributes = productAttributes;
		this.imagePaths = imagePaths;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	/**
	 * 
	 */
	public ProductDto() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDto [productId=").append(productId).append(", productCode=").append(productCode)
				.append(", productName=").append(productName).append(", status=").append(status).append(", mrp=")
				.append(mrp).append(", ssp=").append(ssp).append(", ymp=").append(ymp).append(", primaryImagePath=")
				.append(primaryImagePath).append(", shortDescription=").append(shortDescription)
				.append(", longDescription=").append(longDescription).append(", dimensions=").append(dimensions)
				.append(", seller=").append(seller).append(", comment=").append(comment).append(", categories=")
				.append(categories).append(", productAttributes=").append(productAttributes).append(", imagePaths=")
				.append(imagePaths).append(", createdAt=").append(createdAt).append(", updatedAt=").append(updatedAt)
				.append("]");
		return builder.toString();
	}
}
