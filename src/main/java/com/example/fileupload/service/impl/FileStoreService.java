package com.example.fileupload.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.config.ApplicationProperties;
import com.example.fileupload.exception.FileUploadException;
import com.example.fileupload.service.StoreService;

@Service("fileStoreService")
public class FileStoreService implements StoreService {
	
	//location of uploaded files
    private static String UPLOAD_LOC = ApplicationProperties.getFileUploadLocation();
    
    private Logger logger = Logger.getLogger(FileStoreService.class);
    
    @Override
	public void writeFileContent(MultipartFile file) throws FileUploadException {
    	List<ApplicationProperties.Errors> errors = new ApplicationProperties().getErrors();
		try (FileWriter fw = new FileWriter(UPLOAD_LOC + file.getOriginalFilename(), true); BufferedWriter bw = new BufferedWriter(fw);) {
			bw.write(new String(file.getBytes()));
			logger.debug(file.getOriginalFilename() + " file saved");
		} catch (IOException e) {
			logger.error("Error writing file: " + file.getOriginalFilename(), e);
			int errorCodeIndex=errors.indexOf("F01");
			throw new FileUploadException(errors.get(errorCodeIndex).getCode(),errors.get(errorCodeIndex).getDescription());
		}
	}
}
