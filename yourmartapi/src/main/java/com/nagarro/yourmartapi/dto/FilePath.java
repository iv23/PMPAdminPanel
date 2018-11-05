/**
 * 
 */
package com.nagarro.yourmartapi.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ishaanvashishth
 *
 */
@XmlRootElement
public class FilePath {
	String filePath;

	/**
	 * @param filePath
	 */
	public FilePath(String filePath) {
		super();
		this.filePath = filePath;
	}

	/**
	 * 
	 */
	public FilePath() {
		super();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
