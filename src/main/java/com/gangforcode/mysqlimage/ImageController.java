package com.gangforcode.mysqlimage;
import com.gangforcode.mysqlimage.entity.FileObj;
import com.gangforcode.mysqlimage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@RestController
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @PostMapping
    public ResponseEntity<FileObj> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(imageService.saveImage(file));
    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws Exception {
        FileObj image = imageService.findById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(image.getContentType()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(image.getData());
    }
}