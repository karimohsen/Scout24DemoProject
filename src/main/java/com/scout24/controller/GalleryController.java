package com.scout24.controller;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Controller
public class GalleryController {


    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/pic/{number}", method = RequestMethod.GET)
    public String getPicByNumber(@PathVariable("number") int number, Map model) {
        InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/" + number + ".jpg");
        try {
            byte[] encodeBase64 = Base64.encodeBase64(IOUtils.toByteArray(in));
            String base64Encoded = new String(encodeBase64, "UTF-8");
            model.put("image", base64Encoded);
        } catch (IOException e) {
        }
        return "gallery";
    }

}