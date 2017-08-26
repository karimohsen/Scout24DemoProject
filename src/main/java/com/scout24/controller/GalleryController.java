package com.scout24.controller;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Controller
public class GalleryController {


    @Autowired
    ServletContext servletContext;

    @RequestMapping(value="/")
    public String defaultHandler(){
        return "redirect:/pic?image=1";
    }

    @RequestMapping(value = "/pic", method = RequestMethod.GET)
    public String getPicByNumber(@RequestParam("image") int number, Map model) {
        if (number < 1) {
            return "redirect:/pic?image=10";
        } else if (number > 10) {
            return "redirect:/pic?image=1";
        }
        InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/" + number + ".jpg");
        try {
            byte[] encodeBase64 = Base64.encodeBase64(IOUtils.toByteArray(in));
            String base64Encoded = new String(encodeBase64, "UTF-8");
            model.put("image", base64Encoded);
            model.put("imageId", number);
        } catch (IOException e) {
        }
        return "gallery";
    }

}