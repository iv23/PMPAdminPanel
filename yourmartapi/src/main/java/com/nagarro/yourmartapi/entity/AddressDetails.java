/**
 * 
 */
package com.nagarro.yourmartapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ishaanvashishth
 *
 */
@Entity(name = "addresses")
@Table(name = "addresses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AddressDetails {
	/**
	 * 
	 */
	public AddressDetails() {
	}

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;
	
	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "pin_code")
	private String pinCode;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	LocalDateTime updatedAt;
	
	@Column(name="created_at")
	@CreationTimestamp
	LocalDateTime createdAt;

	/**
	 * @param addressId
	 * @param address
	 * @param address2
	 * @param city
	 * @param state
	 * @param country
	 * @param pinCode
	 */
	public AddressDetails(int addressId, String address, String address2, String city, String state, String country,
			String pinCode) {
		this.addressId = addressId;
		this.addressLine1 = address;
		this.addressLine2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}
	
	/**
	 * @param address
	 * @param address2
	 * @param city
	 * @param state
	 * @param country
	 * @param pinCode
	 */
	public AddressDetails(String address, String address2, String city, String state, String country,
			String pinCode) {
		this.addressLine1 = address;
		this.addressLine2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return addressLine1;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.addressLine1 = address;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return addressLine2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.addressLine2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	

}
