package us.milessmiles.imgtagger.imgtagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import us.milessmiles.imgtagger.imgtagger.contract.ImageItemResponse;
import us.milessmiles.imgtagger.imgtagger.contract.UploadRequest;
import us.milessmiles.imgtagger.imgtagger.service.ImageService;

@RestController()
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(path="/image")
    public ImageItemResponse uploadImage(@RequestBody UploadRequest request) {
        return imageService.uploadImage(request.getImageUrl(), request.getName(), request.getObjectDetection());
    }

    @GetMapping(path="/image/{id}")
    public ImageItemResponse getImage(@PathVariable("id") Long id) {
        return imageService.getImage(id);
    }

    @GetMapping(path="/image")
    public Page<ImageItemResponse> getImage(@RequestParam(name="objects") String tag,
                                            @RequestParam(name="minConfidence", required = false) Float confidence,
                                            @PageableDefault(size=25, sort="id") Pageable pageable) {
        return imageService.getImagesWithTag(pageable, tag, confidence);
    }


}
