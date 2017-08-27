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

    //this method is accessed when calling localhost:8080 and it redirect to the gallery page to show the first image
    @RequestMapping(value = "/")
    public String defaultUrlHandler() {
        return "redirect:/gallery?image=1";
    }

    /*this method is the core of the project it takes an image number and via service class it gets the byte array and set it in the model
      to be accessed and show it as an image and in the method we set also the image number and the number of images in our server
      (for the image counter) */
    @RequestMapping(value = "/gallery", method = RequestMethod.GET)
    public String getPicByNumber(@RequestParam("image") int number, Map model) {
        if (number < 1) {
            //to handle if the user is currently viewing the first image and the pressed “previous button”
            return "redirect:/gallery?image=10";
        } else if (number > 10) {
            //to handle if the user is currently viewing the last image and then pressed “next button”
            return "redirect:/gallery?image=1";
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