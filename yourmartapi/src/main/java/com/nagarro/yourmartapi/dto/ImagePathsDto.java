/**
 * 
 */
package com.nagarro.yourmartapi.dto;

/**
 * @author ishaanvashishth
 *
 */
public class ImagePathsDto {
	
	private int imageId;
	private String imagePath;
	private ProductDto product;
	/**
	 * @return the imageId
	 */
	public int getImageId() {
		return imageId;
	}
	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	 * @param imageId
	 * @param imagePath
	 * @param product
	 */
	public ImagePathsDto(int imageId, String imagePath, ProductDto product) {
		this.imageId = imageId;
		this.imagePath = imagePath;
		this.product = product;
	}
	/**
	 * 
	 */
	public ImagePathsDto() {
	}

}
