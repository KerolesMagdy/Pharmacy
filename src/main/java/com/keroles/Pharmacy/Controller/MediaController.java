/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Controller;

import java.io.IOException;
import java.nio.file.FileSystems;

import com.keroles.Pharmacy.Constant.ConstantSystemConfig;
import com.keroles.Pharmacy.Media.ImageOp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import static com.keroles.Pharmacy.Constant.ConstantURI.*;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Keroles Magdy
 */
@RestController
public class MediaController {
    @RequestMapping(value = upload_image_uri,method = RequestMethod.POST)
    public ResponseEntity<Object> imageUpload(@RequestParam("File")MultipartFile file) throws IOException{
        ImageOp imageOp=new ImageOp();
        return imageOp.uploadImage(file);
    }

}
