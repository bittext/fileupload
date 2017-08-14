package com.example.fileupload.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.fileupload.exception.FileUploadException;

public interface StoreService {
	public void writeFileContent(MultipartFile file) throws FileUploadException;
}
