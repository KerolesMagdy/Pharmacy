/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Media;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;

import com.keroles.Pharmacy.Constant.ConstantSystemConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Keroles Magdy
 */
public class ImageOp {
    public ResponseEntity<Object> uploadImage(MultipartFile file) throws IOException{
        String photoDirectory = SharedMediaOp.getPhotoPath(file);

        System.out.println(photoDirectory);
        File myFile=new File(photoDirectory);
        myFile.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(myFile)) {
            fos.write(file.getBytes());
        }
        catch(Exception exception){
        return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity<Object>(photoDirectory,HttpStatus.OK);
    }

}
