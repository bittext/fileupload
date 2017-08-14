package com.example.fileupload.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.fileupload.exception.FileUploadException;

public interface FileMetaDataService {
	public void create(MultipartFile file) throws FileUploadException;
}
