package com.example.fileupload.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
		System.out.println("Error list: " + new ApplicationProperties().getErrors().size());
		List<ApplicationProperties.Errors> errors = new ApplicationProperties().getErrors();
		if (!errors.isEmpty()) {
			System.out.println("lst is not empty");
			System.out.println(errors.get(0));
			System.out.println(errors.get(1));
			System.out.println(errors.get(2));
		}
		System.out.println("Name: " + ApplicationProperties.getName());
		 try {
			FileWriter fw = new FileWriter(UPLOADED_FILE, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(new String(file.getBytes()));
			if(true)
				throw new FileUploadException("A123","IOException");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileUploadException("A123","IOException");
		}
	}

}
