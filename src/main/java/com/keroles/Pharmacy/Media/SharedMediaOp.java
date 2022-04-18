package com.keroles.Pharmacy.Media;

import com.keroles.Pharmacy.Constant.ConstantSystemConfig;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileSystems;

import static com.keroles.Pharmacy.PharmacyApplication.app_mode;

public class SharedMediaOp {
    private static String getSystemPath(){
        String systemDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();

        return systemDirectory;
    }
    public static String getPhotoPath( MultipartFile file){
        String systemDirectory=getSystemPath();
        if(app_mode == ConstantSystemConfig.system_mode.dev)
            return systemDirectory+"\\photo\\"+file.getOriginalFilename();

        return systemDirectory+"\\tomcat\\webapps\\pharmacy-app\\media\\photo\\"+file.getOriginalFilename();
    }

}
