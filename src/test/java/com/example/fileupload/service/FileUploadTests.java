package com.example.fileupload.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.fileupload.exception.FileUploadException;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FileUploadTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StoreService storeService;

    @Test
    public void shouldWriteFile() throws FileUploadException {
    	MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
                "text/plain", "Text content for testing".getBytes());
        this.storeService.writeFileContent(multipartFile);
        
    }
    
    
}