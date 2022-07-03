package us.milessmiles.imgtagger.imgtagger.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import us.milessmiles.imgtagger.imgtagger.contract.ImageItemResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
public interface ImageService {
    ImageItemResponse uploadImage(@NotBlank String url, String name, Boolean withObjectDetection);
    ImageItemResponse getImage(@NotNull Long id);
    Page<ImageItemResponse> getImagesWithTag(Pageable pageable, @NotBlank String tag, Float confidence);
}
