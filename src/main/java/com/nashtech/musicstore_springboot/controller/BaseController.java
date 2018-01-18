package com.nashtech.musicstore_springboot.controller;

import com.nashtech.musicstore_springboot.utilities.ConstantValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class BaseController {
    public boolean validateFileSize(long fileSize) {
        if (fileSize > ConstantValues.MAX_SIZE_UPLOAD) {
            return false;
        }
        return true;
    }

    public boolean validateFileType(String fileType) {
        //fileType return type/extension (ex: image/png)
        if (!ConstantValues.LIST_IMAGE_TYPES.contains(fileType.split("/")[1])) { //split fileType and get only the extension
            return false;
        }
        return true;
    }

    public boolean uploadFileSuccess(MultipartFile file,
                                     HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            ServletContext sc = session.getServletContext();
            String imagePath = sc.getRealPath("/") + ConstantValues.UPLOAD_DIRECTORY;
            File theDir = new File(imagePath);
            if (!theDir.exists()) {
                try {
                    theDir.mkdir();
                } catch (SecurityException se) {
                }
            }
            InputStream inputStream = null;
            OutputStream outputStream = null;
            if (file.getSize() > 0) {
                inputStream = file.getInputStream();
                File newFile = new File(imagePath + file.getOriginalFilename());
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                outputStream = new FileOutputStream(imagePath + file.getOriginalFilename());
                int readBytes = 0;
                byte[] buffer = new byte[8192];
                while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
                    outputStream.write(buffer, 0, readBytes);
                }
                outputStream.close();
                inputStream.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
