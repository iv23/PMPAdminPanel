/**
 * 
 */
package com.nagarro.yourmartapi.dto;

import java.time.LocalDateTime;

/**
 * @author ishaanvashishth
 *
 */
public class SellerDto {
	private Integer sellerId;
	private String companyName;
	private String ownerName;
	private AddressDto address;
	private String email;
	private String telephone;
	private String gstNumber;
	private String password;
	private String status;
	/**
	 * 
	 */
	public SellerDto() {
	}
	/**
	 * @param sellerId
	 * @param companyName
	 * @param ownerName
	 * @param address
	 * @param email
	 * @param telephone
	 * @param gstNumber
	 * @param password
	 * @param status
	 * @param createdAt
	 * @param updatedAt
	 */
	public SellerDto(Integer sellerId, String companyName, String ownerName, AddressDto address, String email,
			String telephone, String gstNumber, String password, String status, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.sellerId = sellerId;
		this.companyName = companyName;
		this.ownerName = ownerName;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.gstNumber = gstNumber;
		this.password = password;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	/**
	 * @return the sellerId
	 */
	public Integer getSellerId() {
		return sellerId;
	}
	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	/**
	 * @return the address
	 */
	public AddressDto getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the gstNumber
	 */
	public String getGstNumber() {
		return gstNumber;
	}
	/**
	 * @param gstNumber the gstNumber to set
	 */
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	

}
