package us.milessmiles.imgtagger.imgtagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import us.milessmiles.imgtagger.imgtagger.service.ImageService;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;



}
