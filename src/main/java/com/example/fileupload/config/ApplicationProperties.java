package com.example.fileupload.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class ApplicationProperties {
	
	private static String fileUploadLocation;

	public static String getFileUploadLocation() {
		return fileUploadLocation;
	}

	public void setFileUploadLocation(String fileUploadLocation) {
		this.fileUploadLocation = fileUploadLocation;
	}
	
	
}
