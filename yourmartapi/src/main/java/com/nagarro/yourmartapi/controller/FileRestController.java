/**
 * 
 */
package com.nagarro.yourmartapi.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nagarro.yourmartapi.dto.FilePath;
import com.nagarro.yourmartapi.service.FileStorageService;

/**
 * @author ishaanvashishth
 *
 */
@RestController
public class FileRestController {
	  private static final Logger logger = LoggerFactory.getLogger(FileRestController.class);

	    @Autowired
	    private FileStorageService fileStorageService;
	    
	    @PostMapping(value="/uploadFile",
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public FilePath uploadFile(@RequestParam("file") MultipartFile file) {
	    	String fileName = fileStorageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();	
	        FilePath fileRes = new FilePath(fileDownloadUri);
	        return fileRes;
	    }

	    @PostMapping(value="/uploadMultipleFiles",
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<FilePath> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
	    	List<FilePath> filePaths = new ArrayList<FilePath>();
	    	for(MultipartFile file: files) {
	    		filePaths.add(uploadFile(file));
	    	}
	    	return filePaths;
	    }
	    

	    @GetMapping(value="/downloadFile/{fileName:.+}")
	    public String downloadFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
	        // Load file as Resource
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	            logger.info("Could not determine file type.");
	        }

	        // Fallback to the default content type if type could not be determined
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }
	        File downloadFile = resource.getFile();
	        byte[] fileContent = FileUtils.readFileToByteArray(downloadFile);
	        String encodedString = Base64.encodeBase64String(fileContent);
	        logger.info(encodedString);
	        return encodedString;
	    }
}
