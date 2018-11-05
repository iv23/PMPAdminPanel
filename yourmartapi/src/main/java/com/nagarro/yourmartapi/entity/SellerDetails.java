/**
 * 
 */
package com.nagarro.yourmartapi.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ishaanvashishth
 *
 */
@Entity(name = "sellers")
@Table(name = "sellers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SellerDetails {

	@Id
	//Generates id starting from 1000
	@TableGenerator(name = "Address_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Addr_Gen", initialValue = 10000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Address_Gen")
	@Column(name = "seller_id")
	private Integer sellerId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "owner_name")
	private String ownerName;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="address_id")
	private AddressDetails address;
	
	@Column(name = "email")
	private String email;

	@Column(name = "telphone")
	private String telephone;

	@Column(name = "gst_number")
	private String gstNumber;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;

	@Column(name = "updated_at")
	@UpdateTimestamp
	LocalDateTime updatedAt;
	
	//Registration timestamp
	@Column(name = "created_at")
	@CreationTimestamp
	LocalDateTime createdAt;

	public SellerDetails() {

	}

	/**
	 * @return the seller_id
	 */
	public Integer getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the seller_id to set
	 */
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getCompanyName() {
		return companyName;
	}

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
	 * @return the address
	 */
	public AddressDetails getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDetails address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SellerDetails [sellerId=").append(sellerId).append(", companyName=").append(companyName)
				.append(", ownerName=").append(ownerName).append(", address=").append(address).append(", email=")
				.append(email).append(", telephone=").append(telephone).append(", gstNumber=").append(gstNumber)
				.append(", password=").append(password).append(", status=").append(status).append(", updatedAt=")
				.append(updatedAt).append(", createdAt=").append(createdAt).append("]");
		return builder.toString();
	}

}
