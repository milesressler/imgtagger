package us.milessmiles.imgtagger.imgtagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.milessmiles.imgtagger.imgtagger.contract.UploadRequest;
import us.milessmiles.imgtagger.imgtagger.contract.UploadResponse;
import us.milessmiles.imgtagger.imgtagger.model.ImageItem;
import us.milessmiles.imgtagger.imgtagger.service.ImageService;

import java.util.List;

@RestController()
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(path="/image")
    public UploadResponse uploadImage(@RequestBody UploadRequest request) {
        return imageService.uploadImage(request.getImageUrl(), request.getName(), request.getObjectDetection());
    }

    @GetMapping(path="/image/{id}")
    public ImageItem getImage(@PathVariable("id") Long id) {
        return imageService.getImage(id);
    }

    @GetMapping(path="/image")
    public List<ImageItem> getImage(@RequestParam(name="objects") String tag,
                                    @RequestParam(name="minConfidence", required = false) Float confidence) {
        return imageService.getImagesWithTag(tag, confidence);
    }


}
