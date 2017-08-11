package com.example.fileupload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.fileupload.service.StoreService;
import com.examples.fileupload.operation.FileUploadOperation;

@Controller
public class FileUploadController {
	
	@Autowired
	FileUploadOperation fileUpload;
	
	
	Logger logger = Logger.getLogger("FileUploadController");
	
	@PostMapping
	public String handleFileUpload(@RequestParam("file") MultipartFile file, 
			RedirectAttributes redirectAttributes ) {
		
		System.out.println("handleFileUPload...");
		logger.debug("debug:FileUploadController..");
		
//		if (file.isEmpty()) {
//			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//			return "redirect:uploadStatus";
//		}
		try {

            
			fileUpload.fileUploadWithMetaData(file);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

	 @GetMapping("/uploadStatus")
	    public String uploadStatus() {
	        return "uploadStatus";
	    }
	 
	 @GetMapping("/")
	    public String index() {
	        return "upload";
	    }
}
