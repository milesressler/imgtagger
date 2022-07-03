package us.milessmiles.imgtagger.imgtagger.service;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import us.milessmiles.imgtagger.imgtagger.contract.ImageItemResponse;
import us.milessmiles.imgtagger.imgtagger.exceptions.BadRequestException;
import us.milessmiles.imgtagger.imgtagger.exceptions.DuplicateEntityException;
import us.milessmiles.imgtagger.imgtagger.exceptions.ErrorCode;
import us.milessmiles.imgtagger.imgtagger.exceptions.NotFoundException;
import us.milessmiles.imgtagger.imgtagger.model.ImageItem;
import us.milessmiles.imgtagger.imgtagger.model.ImageItemTag;
import us.milessmiles.imgtagger.imgtagger.repository.ImageItemRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DefaultImageService implements ImageService {

    @Autowired
    ImageProcessingService imageProcessingService;

    @Autowired
    ImageItemRepository imageItemRepository;

    @Override
    public ImageItemResponse uploadImage(String url, String name, Boolean withObjectDetection) {
        final UrlValidator validator = new UrlValidator();
        if (!validator.isValid(url)) {
            throw new BadRequestException("URL is invalid", ErrorCode.URL_INVALID, new HashMap<>(Map.of("url", url)));
        }

        final Optional<ImageItem> existing = imageItemRepository.findFirstByUrl(url);
        existing.ifPresent(i -> { throw new DuplicateEntityException("ImageItem", null); });

        final ImageItem image;
        if (withObjectDetection != null && withObjectDetection) {
            List<ImageItemTag> tags = imageProcessingService.getTags(url);
            image = new ImageItem(url, name, tags);
        } else {
            image = new ImageItem(url, name, null);
        }
        imageItemRepository.save(image);
        return image.toResponse();
    }

    @Override
    public ImageItemResponse getImage(Long id) {
        Optional<ImageItem> imageItem =  imageItemRepository.findById(id);
        return imageItem.orElseThrow(() -> new NotFoundException("Image not found",
                ErrorCode.OBJECT_NOT_FOUND,
                new HashMap<>(Map.of("id", id)))).toResponse();
    }

    @Override
    public Page<ImageItemResponse> getImagesWithTag(Pageable pageable, String tag, Float confidence) {
        final Page<ImageItem> items;
        if (tag.isBlank()) {
            items = imageItemRepository.findAll(pageable);
        } else if (confidence == null) {
            items = imageItemRepository.findByTagsTag(pageable, tag);
        } else {
            if (confidence > 100 || confidence < 0) {
                throw new BadRequestException("Confidence must be between 0 and 1", ErrorCode.INVALID_INPUT, new HashMap<>(Map.of("confidence", confidence)));
            } else {
                items = imageItemRepository.findByTagsTagAndTagsConfidenceGreaterThan(pageable, tag, confidence);
            }
        }

        return items.map(ImageItem::toResponse);

    }


}

