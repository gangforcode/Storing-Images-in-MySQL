package com.gangforcode.mysqlimage.service;
import com.gangforcode.mysqlimage.entity.FileObj;
import com.gangforcode.mysqlimage.repo.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@Service
public class ImageService {
    @Autowired
    private FileRepo imageRepository;
    public FileObj saveImage(MultipartFile file) throws IOException {
        FileObj fileObj = new FileObj() ;
        fileObj.setName(file.getOriginalFilename());
        fileObj.setContentType(file.getContentType());
        fileObj.setData(file.getBytes());
        return imageRepository.save(fileObj);
    }
    public FileObj findById(Long id) throws Exception {
            FileObj image = imageRepository.findById(id).orElseThrow(() -> new Exception("Image not found"));
            return image;
        }
}