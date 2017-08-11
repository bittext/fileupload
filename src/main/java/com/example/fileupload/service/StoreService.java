package com.example.fileupload.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.entity.FileMetaData;

public interface StoreService {
	public void writeFileContent(MultipartFile file) throws IOException;
	public void writeFileMetaData(FileMetaData data) throws IOException;
}
