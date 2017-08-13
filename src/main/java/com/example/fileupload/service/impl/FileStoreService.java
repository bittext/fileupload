package com.example.fileupload.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.config.ApplicationProperties;
import com.example.fileupload.exception.FileUploadException;
import com.example.fileupload.service.StoreService;

@Service("fileStoreService")
public class FileStoreService implements StoreService {
	
	//Save the uploaded file to this folder
    private static String UPLOADED_FILE = "c:///tmp///myfile.txt";
    
    
	
	@Override
	public void writeFileContent(MultipartFile file) throws FileUploadException {
		System.out.println("fileStoreService code called....");
		System.out.println("File Upload Location: " + ApplicationProperties.getFileUploadLocation());
        try {
			FileWriter fw = new FileWriter(UPLOADED_FILE, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(new String(file.getBytes()));
			if(false)
				throw new FileUploadException("A123","IOException");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileUploadException("A123","IOException");
		}
	}

}
