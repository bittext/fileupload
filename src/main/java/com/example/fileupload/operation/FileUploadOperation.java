package com.example.fileupload.operation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.dao.FileMetaDataDao;
import com.example.fileupload.entity.FileMetaData;
import com.example.fileupload.service.FileMetaDataService;
import com.example.fileupload.service.StoreService;

@Component
public class FileUploadOperation {
	
	@Autowired
	@Qualifier ("fileStoreService")
	StoreService fileStoreService;
	
	@Autowired
	@Qualifier("fileDBService")
    FileMetaDataService FileMetaDataService;
	
	
	@Autowired
	FileMetaData fileMetaData;
	
	public void fileUploadWithMetaData(MultipartFile file) throws IOException {
		//if application setup is for FileStore
		
		//save the file using fileStoreService
		
		fileMetaData.setName(file.getOriginalFilename());
		fileMetaData.setType(file.getContentType());
		
		fileStoreService.writeFileContent(file);
		
		System.out.println("File Name: " + fileMetaData.getName());
		System.out.println("File Type: " + fileMetaData.getType());
		
		FileMetaDataService.create(fileMetaData);
		
//		fileStoreService.writeFileMetaData(fileMetaData, repository);
	}
	
	
}
