package com.nagarro.yourmartapi;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.nagarro.yourmartapi.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class YourmartapiApplication implements CommandLineRunner{
	
	ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(YourmartapiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(YourmartapiApplication.class, args);
		
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
	}
	
}
