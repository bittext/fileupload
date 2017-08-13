package com.example.fileupload.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.fileupload.entity.FileMetaData;

@Repository
public class FileMetaDataDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void create(FileMetaData data) {
		entityManager.merge(data);
	}

}
