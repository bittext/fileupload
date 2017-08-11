package com.example.fileupload.data;

import org.springframework.stereotype.Controller;

@Controller
public class FileMetaData {
	
	private String name;
	private String size;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
