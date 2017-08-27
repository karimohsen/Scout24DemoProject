package com.scout24.service;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Karim on 8/27/2017.
 */
@Service
public class GalleryService {
    //

    @Autowired
    ServletContext servletContext;

    public byte[] getImageAsByteArray(int imageNumber) {
        InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/" + imageNumber + ".jpg");
        byte[] encodeBase64 = new byte[0];
        try {
            encodeBase64 = Base64.encodeBase64(IOUtils.toByteArray(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodeBase64;
    }
}