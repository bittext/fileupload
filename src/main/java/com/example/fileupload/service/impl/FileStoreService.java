package com.example.fileupload.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.example.fileupload.entity.FileMetaData;
import com.example.fileupload.service.StoreService;

@Service("fileStoreService")
public class FileStoreService implements StoreService {
	
	//Save the uploaded file to this folder
    private static String UPLOADED_FILE = "c:///tmp///myfile.txt";
    
    
	
	@Override
	public void writeFileContent(MultipartFile file) throws IOException {
		System.out.println("fileStoreService code called....");
        FileWriter fw = new FileWriter(UPLOADED_FILE, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(new String(file.getBytes()));
        bw.close();
        System.out.println("Appended file completed.");
	}

}
