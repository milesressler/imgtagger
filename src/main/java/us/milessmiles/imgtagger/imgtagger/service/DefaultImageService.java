package us.milessmiles.imgtagger.imgtagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.milessmiles.imgtagger.imgtagger.contract.UploadResponse;
import us.milessmiles.imgtagger.imgtagger.exceptions.BadRequestException;
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
    public UploadResponse uploadImage(String url, String name, Boolean withObjectDetection) {
        // TODO validate url
        // TODO check if exists already
        ImageItem image;
        if (withObjectDetection != null && withObjectDetection) {
            List<ImageItemTag> tags = imageProcessingService.getTags(url);
            image = new ImageItem(url, name, tags);
        } else {
            image = new ImageItem(url, name, null);
        }
        return new UploadResponse(true, imageItemRepository.save(image));
    }

    @Override
    public ImageItem getImage(Long id) {
        Optional<ImageItem> imageItem =  imageItemRepository.findById(id);
        return imageItem.orElseThrow(() -> new NotFoundException("Image not found",
                ErrorCode.OBJECT_NOT_FOUND,
                new HashMap<>(Map.of("id", id))));
    }

    @Override
    public List<ImageItem> getImagesWithTag(String tag, Float confidence) {
        if (tag.isBlank()) {
            return imageItemRepository.findAll();
        }

        if (confidence == null) {
            return imageItemRepository.findByTagsTag(tag);
        } else {
            if (confidence > 100 || confidence < 0) {
                throw new BadRequestException("Confidence must be between 0 and 1", ErrorCode.INVALID_INPUT, new HashMap<>(Map.of("confidence", confidence)));
            } else {
                return imageItemRepository.findByTagsTagAndTagsConfidenceGreaterThan(tag, confidence);
            }
        }
    }


}

