package com.devops.studylink.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    
    /** Save files **/
    @Value("${file.upload.dir}")
    String FILE_UPLOAD_DIR;

    @PostMapping()
    public ResponseEntity uploadFile( @RequestParam("file") MultipartFile file ) throws IOException {
        
        // if (file == null) return ResponseEntity.ok("Null");
        // else return ResponseEntity.ok(file.getName());
        File f = new File( FILE_UPLOAD_DIR + file.getOriginalFilename() );
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write( file.getBytes() );
        fos.close();
        return ResponseEntity.noContent().build();

    }

}
