package com.scout24.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by Karim on 8/27/2017.
 */
public class GalleryControllerTest {


    @Test
    public void testDefaultUrlHandler() throws Exception {
        GalleryController controller = new GalleryController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("redirect:/gallery?image=1"));
    }

    @Test
    public void getPicByNumber1() throws Exception {
        GalleryController controller = new GalleryController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/gallery?image=11")).andExpect(view().name("redirect:/gallery?image=1"));
    }

    @Test
    public void getPicByNumber2() throws Exception {
        GalleryController controller = new GalleryController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/gallery?image=0")).andExpect(view().name("redirect:/gallery?image=10"));
    }


}
