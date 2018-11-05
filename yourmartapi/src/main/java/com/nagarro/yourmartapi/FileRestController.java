/**
 * 
 */
package com.nagarro.yourmartapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nagarro.yourmartapi.dto.FilePath;
import com.nagarro.yourmartapi.service.FileStorageService;
import com.nagarro.yourmartapi.service.SellerPanelService;

/**
 * @author ishaanvashishth
 *
 */
@RestController
public class FileRestController {
	  private static final Logger logger = LoggerFactory.getLogger(FileRestController.class);

	    @Autowired
	    private FileStorageService fileStorageService;
	    @Autowired
	    private SellerPanelService sellerService;
	    
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
	    

	    @GetMapping("/downloadFile/{fileName:.+}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
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

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }
}
