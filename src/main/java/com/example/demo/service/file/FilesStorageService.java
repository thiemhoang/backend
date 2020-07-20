package com.example.demo.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageService {
	
	private static final String PATH = "uploads/";

	private void init(long userId) {
		Path root = Paths.get(PATH + userId);
		try {
			if(!Files.exists(root)) {
				Files.createDirectory(root);
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	public String save(MultipartFile file, long userId) {
		try {
			Path path = Paths.get(PATH + userId).resolve(file.getOriginalFilename());
			init(userId);
			Files.copy(file.getInputStream(), path);
			return PATH + userId + "/" + file.getOriginalFilename();
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}
	
	public boolean exist(MultipartFile file, long userId) {
		return Files.exists(Paths.get(PATH + userId).resolve(file.getOriginalFilename()));
	}
}
