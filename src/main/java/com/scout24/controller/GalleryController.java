package com.scout24.controller;

import com.scout24.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
public class GalleryController {

    private static final int NUMBER_OF_IMAGES = 10;

    @Autowired
    GalleryService galleryService;


    @RequestMapping(value = "/")
    public String defaultUrlHandler() {
        return "redirect:/pic?image=1";
    }

    @RequestMapping(value = "/pic", method = RequestMethod.GET)
    public String getPicByNumber(@RequestParam("image") int number, Map model) {
        if (number < 1) {
            return "redirect:/pic?image=10";
        } else if (number > 10) {
            return "redirect:/pic?image=1";
        }
        String base64Encoded = null;
        try {
            base64Encoded = new String(galleryService.getImageAsByteArray(number), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.put("image", base64Encoded);
        model.put("imageId", number);
        model.put("numberOfImages", NUMBER_OF_IMAGES);

        return "gallery";
    }

}