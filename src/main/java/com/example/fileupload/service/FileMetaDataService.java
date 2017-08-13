package com.example.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.entity.FileMetaData;

public interface FileMetaDataService {
	public void create(MultipartFile file);
}
