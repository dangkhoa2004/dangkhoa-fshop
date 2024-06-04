/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author 04dkh
 */
@Service
public class FileStorageService {
    @Value("${file.upload-dir}")
    public String uploadDir;

    public void saveFile(MultipartFile file, String folderName) throws IOException {
        Path folderPath = Paths.get(uploadDir + File.separator + folderName);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        Path filePath = folderPath.resolve(file.getOriginalFilename());
        Files.write(filePath, file.getBytes());
    }
}
