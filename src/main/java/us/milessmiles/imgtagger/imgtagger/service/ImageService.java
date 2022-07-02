package us.milessmiles.imgtagger.imgtagger.service;

import us.milessmiles.imgtagger.imgtagger.contract.UploadResponse;
import us.milessmiles.imgtagger.imgtagger.model.ImageItem;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
public interface ImageService {
    UploadResponse uploadImage(@NotBlank String url, String name, Boolean withObjectDetection);
    ImageItem getImage(@NotNull Long id);
    List<ImageItem> getImagesWithTag(@NotBlank String tag, Float confidence);
}
