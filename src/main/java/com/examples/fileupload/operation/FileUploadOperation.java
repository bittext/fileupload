package com.examples.fileupload.operation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.data.FileMetaData;
import com.example.fileupload.service.StoreService;

@Component
public class FileUploadOperation {
	
	@Autowired
	@Qualifier ("fileStoreService")
	StoreService fileStoreService;
	
	@Autowired
	FileMetaData fileMetaData;
	
	public void fileUploadWithMetaData(MultipartFile file) throws IOException {
		//if application setup is for FileStore
		
		//save the file using fileStoreService
		
		fileMetaData.setName(file.getName());
		fileMetaData.setType(file.getContentType());
		
		fileStoreService.writeFileContent(file);
		
		fileStoreService.writeFileMetaData(fileMetaData);
	}
	
	
}
