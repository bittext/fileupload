package com.example.fileupload.exception;

public class FileUploadException extends Exception {
	
	private static final long serialVersionUID = -1L;
	private String code;
	private String description;
	
	public FileUploadException() {
	}
	
	public FileUploadException(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return String.format("FileUploadException[code:'%s', description:'%s']", this.code, this.description);
	}
}
