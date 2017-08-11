package com.example.fileupload.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fileupload.dao.FileMetaDataDao;
import com.example.fileupload.entity.FileMetaData;
import com.example.fileupload.service.FileMetaDataService;


@Service("fileDBService")
public class FileMetaDataH2Service implements FileMetaDataService {
	
	@Autowired
	private FileMetaDataDao fileMetaDataDao;
	
	@Transactional
	public void create(FileMetaData data) {
		fileMetaDataDao.create(data);
	}

}
