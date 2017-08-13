package com.example.fileupload.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.dao.FileMetaDataDao;
import com.example.fileupload.entity.FileMetaData;
import com.example.fileupload.service.FileMetaDataService;


@Service("fileDBService")
public class FileMetaDataH2Service implements FileMetaDataService {
	
	@Autowired
	private FileMetaDataDao fileMetaDataDao;
	
	@Autowired
	private FileMetaData fileMetaData;
	
	
	@Transactional
	public void create(MultipartFile file) {
		fileMetaData.setName(file.getName());
		fileMetaData.setType(file.getContentType());
		fileMetaData.setSize(Double.valueOf(file.getSize()/1024));
		fileMetaDataDao.create(fileMetaData);
	}

}
