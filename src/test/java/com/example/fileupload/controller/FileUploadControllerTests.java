package com.example.fileupload.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FileUploadControllerTests {
	
	@Autowired
	FileUploadController fileUploadController;
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnWithNoErrors() throws Exception {
    	MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
                "text/plain", "Text content for testing".getBytes());
        this.mockMvc.perform(get("/",multipartFile)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Success")));
    }
}
