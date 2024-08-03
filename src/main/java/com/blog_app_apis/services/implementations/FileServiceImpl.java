package com.blog_app_apis.services.implementations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog_app_apis.services.FileService;

@Service
public class FileServiceImpl implements FileService{

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // get file name
        String name = file.getOriginalFilename();

        // get random file name
        String randomId = UUID.randomUUID().toString();
        String randomPathName = randomId.concat(name.substring(name.lastIndexOf(".")));

        // file path
        String filePath = path+File.separator+randomPathName;

        // folder exist or not
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));
        return randomPathName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
         String fullPath = path+File.separator+fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }
    
}
