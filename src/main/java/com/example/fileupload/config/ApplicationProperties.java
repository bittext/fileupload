package com.example.fileupload.config;

import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class ApplicationProperties {
	
	private static String fileUploadLocation;
	private static String name;
	private static List<Errors> errors = new ArrayList<>();

	public static String getFileUploadLocation() {
		return fileUploadLocation;
	}

	public void setFileUploadLocation(String fileUploadLocation) {
		this.fileUploadLocation = fileUploadLocation;
	}
	
	
	

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ApplicationProperties.name = name;
	}

	public  void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

	public  List<Errors> getErrors() {
		return errors;
	}

	


	public static class Errors {
	        private String code;
	        private String description;

	       public Errors() {}
	       public Errors(String code, String description) {
	    	   this.code = code;
	    	   this.description = description;
	       }

	        public String getCode() {
				return code;
			}



			public void setCode(String code) {
				this.code = code;
			}



			public String getDescription() {
				return description;
			}



			public void setDescription(String description) {
				this.description = description;
			}



			@Override
	        public String toString() {
	            return "Errors{" +
	                    "code='" + code + '\'' +
	                    ", description='" + description + '\'' +
//	                    "error='=" + error + '\'' + 
//	                    "errors='=" + errors + '\'' + 
	                    '}';
	        }
	    }
	
	
}
