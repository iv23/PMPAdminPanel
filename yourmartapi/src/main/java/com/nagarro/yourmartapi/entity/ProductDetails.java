/**
 * 
 */
package com.nagarro.yourmartapi.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author ishaanvashishth
 *
 */
@Entity(name = "products")
@Table(name = "products")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProductDetails {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "status")
	private String status;

	@Column(name = "mrp")
	private double mrp;

	@Column(name = "ssp")
	private double ssp;

	@Column(name = "ymp")
	private double ymp;

	@Column(name = "primary_image_path")
	private String primaryImagePath;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "long_description")
	private String longDescription;

	@Column(name = "usage_instr_path")
	private String usageInstrPath;

	@Column(name = "dimensions")
	private String dimensions;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "seller_id")

	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sellerId")
	@JsonIdentityReference(alwaysAsId = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
	private SellerDetails seller;

	@Column(name = "comment")
	private String comment;

	@Column(name = "updated_at")
	@UpdateTimestamp
	LocalDateTime updatedAt;

	@Column(name = "created_at")
	@CreationTimestamp
	LocalDateTime createdAt;

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "product_categories", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
//  @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="productId")
//  @JsonIdentityReference(alwaysAsId=true)
//  @JsonProperty("product_id")
	Set<CategoryDetails> categories = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductAttributes> productAttributes = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ImagePaths> imagePaths = new HashSet<>();

	/**
	 * @param productCode
	 * @param productName
	 * @param status
	 * @param mrp
	 * @param ssp
	 * @param ymp
	 * @param primaryImagePath
	 * @param shortDescription
	 * @param longDescription
	 * @param usageInstrPath
	 * @param dimensions
	 * @param seller
	 */
	public ProductDetails(String productCode, String productName, String status, double mrp, double ssp, double ymp,
			String primaryImagePath, String shortDescription, String longDescription, String usageInstrPath,
			String dimensions) {
		this.productCode = productCode;
		this.productName = productName;
		this.status = status;
		this.mrp = mrp;
		this.ssp = ssp;
		this.ymp = ymp;
		this.primaryImagePath = primaryImagePath;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.usageInstrPath = usageInstrPath;
		this.dimensions = dimensions;
	}

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
	 * 
	 */
	public ProductDetails() {
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
	 * @return the usageInstrPath
	 */
	public String getUsageInstrPath() {
		return usageInstrPath;
	}

	/**
	 * @param usageInstrPath the usageInstrPath to set
	 */
	public void setUsageInstrPath(String usageInstrPath) {
		this.usageInstrPath = usageInstrPath;
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
	public SellerDetails getSeller() {
		return seller;
	}

	/**
	 * @param seller the seller to set
	 */
	public void setSeller(SellerDetails seller) {
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
	 * @return the categories
	 */
	public Set<CategoryDetails> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void addCategory(CategoryDetails category) {
		if (this.categories.contains(category))
			return;
		this.categories.add(category);
	}

	/**
	 * @return the productAttributes
	 */
	public Set<ProductAttributes> getProductAttributes() {
		return productAttributes;
	}

	/**
	 * @param productAttributes the productAttributes to set
	 */
	public void setProductAttributes(Set<ProductAttributes> productAttributes) {
		this.productAttributes = productAttributes;
	}

	/**
	 * @return the imagePaths
	 */
	public Set<ImagePaths> getImagePaths() {
		return imagePaths;
	}

	/**
	 * @param imagePaths the imagePaths to set
	 */
	public void setImagePaths(Set<ImagePaths> imagePaths) {
		this.imagePaths = imagePaths;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDetails [productId=").append(productId).append(", productCode=").append(productCode)
				.append(", productName=").append(productName).append(", status=").append(status).append(", mrp=")
				.append(mrp).append(", ssp=").append(ssp).append(", ymp=").append(ymp).append(", primaryImagePath=")
				.append(primaryImagePath).append(", shortDescription=").append(shortDescription)
				.append(", longDescription=").append(longDescription).append(", usageInstrPath=").append(usageInstrPath)
				.append(", dimensions=").append(dimensions).append(", seller=").append(seller).append(", comment=")
				.append(comment).append(", updatedAt=").append(updatedAt).append(", createdAt=").append(createdAt)
				.append(", categories=").append(categories).append(", productAttributes=").append(productAttributes)
				.append(", imagePaths=").append(imagePaths).append("]");
		return builder.toString();
	}

}
