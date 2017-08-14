package com.example.fileupload.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.fileupload.entity.FileMetaData;
import com.example.fileupload.exception.FileUploadException;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = {RepositoryConfiguration.class})


public class FileH2DBStoreTests {
	
	private FileMetaData fileMetaData;
	@Autowired
	@Qualifier("fileDBService")
	FileMetaDataService fileMetaDataService;
	
	@Autowired
	public void setProductRepository(FileMetaData fileMetaData) {
		this.fileMetaData = fileMetaData;
	}
	
	@Test
	public void testCreateFileMetaData() throws FileUploadException {
		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
                "text/plain", "Text content for testing".getBytes());
		fileMetaDataService.create(multipartFile);
	}
}
