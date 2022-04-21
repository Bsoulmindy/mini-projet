package com.terroir.services;

import java.io.IOException;

import com.terroir.entities.Produit;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.io.InputStream;

@Service
public class FileService {

	public void uploadImageToProduit(MultipartFile image, Produit produit) throws IOException {
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		
		saveFile("src/main/webapp/images/", fileName, image);
	

		produit.setProduit_image("/images/" + fileName);
	}

	private void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}
}
