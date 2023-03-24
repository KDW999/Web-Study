package com.kdw.board.service.implementation;
import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kdw.board.service.FileService;

@Service
public class FileServiceImplements implements FileService {
    
    @Value("${file.path}")
    private String FILE_PATH;

    @Value("${file.url}")
    private String FILE_URL;

    public String upload(MultipartFile file){

        if(file.isEmpty()) return null;

        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 첫 인덱스 부터 뒤에 첫 번째 . 까지 잘라내버려서 확장자명만 남김

        String uuid = UUID.randomUUID().toString();

        String saveName = uuid + extension;
        String savePath = FILE_PATH + saveName;

        try {
            file.transferTo(new File(savePath));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        String url = FILE_URL + saveName;
        return url;
    }

    public Resource getFile(String fileName){
        Resource resource = null;

        try {
            resource = new UrlResource("file:"+ FILE_PATH + fileName);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return resource;
    }
}
