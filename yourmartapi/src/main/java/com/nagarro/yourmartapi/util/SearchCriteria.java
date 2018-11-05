/**
 * 
 */
package com.nagarro.yourmartapi.util;

/**
 * @author ishaanvashishth
 *
 */
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * 
	 */
	public SearchCriteria() {
	}
	/**
	 * @param key
	 * @param operation
	 * @param value
	 */
	public SearchCriteria(String key, String operation, Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
}
