package com.example.fileupload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.fileupload.domain.FileUploadResponse;
import com.example.fileupload.exception.FileUploadException;
import com.example.fileupload.service.FileMetaDataService;
import com.example.fileupload.service.StoreService;

import io.swagger.annotations.Api;

@Controller
@Api(value="fileupload", description="Controller for fileupload operations")
public class FileUploadController {
	
	@Autowired
	FileMetaDataService fileMetaDataService;
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	FileUploadResponse fileUploadResponse;
	
	Logger logger = Logger.getLogger("FileUploadController");
	
	@PostMapping
	public ResponseEntity<?> fileUploadHandler(@RequestParam("file") MultipartFile file) {
		
		if (file ==null || file.isEmpty()) {
			return new ResponseEntity<FileUploadResponse>(fileUploadResponse,HttpStatus.OK);
		}
		
		try {
			fileMetaDataService.create(file);
			storeService.writeFileContent(file);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<FileUploadResponse>(fileUploadResponse,HttpStatus.OK);

    }

	 @GetMapping("/uploadStatus")
	    public String uploadStatus() {
	        return "uploadStatus";
	    }
	 
	 @GetMapping("/")
	    public String index() {
	        return "upload";
	    }
}
