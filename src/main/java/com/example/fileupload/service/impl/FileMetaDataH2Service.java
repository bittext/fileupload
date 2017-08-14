package com.example.fileupload.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.config.ApplicationProperties;
import com.example.fileupload.dao.FileMetaDataDao;
import com.example.fileupload.entity.FileMetaData;
import com.example.fileupload.exception.FileUploadException;
import com.example.fileupload.service.FileMetaDataService;


@Service("fileDBService")
public class FileMetaDataH2Service implements FileMetaDataService {
	
	@Autowired
	private FileMetaDataDao fileMetaDataDao;
	@Autowired
	private FileMetaData fileMetaData;
	private Logger logger = Logger.getLogger(FileMetaDataH2Service.class);
	private static int SIZE_TO_MB = 1024;
	
	
	@Transactional
	public void create(MultipartFile file) throws FileUploadException {
		List<ApplicationProperties.Errors> errors = new ApplicationProperties().getErrors();
		fileMetaData.setName(file.getOriginalFilename());
		fileMetaData.setType(file.getContentType());
		fileMetaData.setSize(Double.valueOf(file.getSize()/SIZE_TO_MB));
		try {
			fileMetaDataDao.create(fileMetaData);
			logger.debug("File" + file.getOriginalFilename() + "meta data saved in database");
		} catch(Exception e) {
			logger.error("Error saving File " + file.getOriginalFilename() + "meta data information", e);
			int errorCodeIndex=errors.indexOf("F02");
			throw new FileUploadException(errors.get(errorCodeIndex).getCode(),errors.get(errorCodeIndex).getDescription());
		}
	}

}
