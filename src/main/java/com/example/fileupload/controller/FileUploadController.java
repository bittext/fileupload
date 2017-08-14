package com.example.fileupload.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.config.ApplicationProperties;
import com.example.fileupload.dto.FileUploadResponse;
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
	
	//max file size permissible to upload
	private static int MAX_FILE_SIZE = 10 * 1024 * 1024; //10MB
	
	Logger logger = Logger.getLogger("FileUploadController");
	
	@PostMapping
	public ResponseEntity<?> fileUploadHandler(@RequestParam("file") MultipartFile file) {
		List<ApplicationProperties.Errors> errors = new ApplicationProperties().getErrors();
		
		//check if file is empty
		if (file == null || file.isEmpty()) {
			int errorCodeIndex=errors.indexOf("F04");
			fileUploadResponse.setErrorCode(errors.get(errorCodeIndex).getCode());
			fileUploadResponse.setErrorDesc(errors.get(errorCodeIndex).getDescription());
			fileUploadResponse.setStatus("Error");
			return new ResponseEntity<FileUploadResponse>(fileUploadResponse,HttpStatus.OK);
		}
		fileUploadResponse.setName(file.getOriginalFilename());
		
		//file size check
		if (file.getSize() > MAX_FILE_SIZE) {
			int errorCodeIndex=errors.indexOf("F05");
			fileUploadResponse.setErrorCode(errors.get(errorCodeIndex).getCode());
			fileUploadResponse.setErrorDesc(errors.get(errorCodeIndex).getDescription());
			fileUploadResponse.setStatus("Error");
			return new ResponseEntity<FileUploadResponse>(fileUploadResponse,HttpStatus.OK);
		}
		
		try {
			fileMetaDataService.create(file);
			storeService.writeFileContent(file);
		} catch (FileUploadException e) {
			fileUploadResponse.setErrorCode(e.getCode());
			fileUploadResponse.setErrorDesc(e.getDescription());
			fileUploadResponse.setStatus("Error");
			return new ResponseEntity<FileUploadResponse>(fileUploadResponse,HttpStatus.OK);
		} catch (Exception e) {
			int errorCodeIndex=errors.indexOf("F03"); //unknown exception
			fileUploadResponse.setErrorCode(errors.get(errorCodeIndex).getCode());
			fileUploadResponse.setErrorDesc(errors.get(errorCodeIndex).getDescription());
			fileUploadResponse.setStatus("Error");
			return new ResponseEntity<FileUploadResponse>(fileUploadResponse,HttpStatus.OK);
		}

		fileUploadResponse.setStatus("Success");
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
