package com.example.fileupload.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class FileMetaData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String type;
	//size in MB's
	private Double size; 
	
	public FileMetaData() {};
	
	public FileMetaData(String name,String Type, Double size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return String.format("FileMetaData[id='%d', name='%s', type='%s', size='%d']",
				id, name, type, size);
	}
	
}
