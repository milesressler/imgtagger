package us.milessmiles.imgtagger.imgtagger.service;

import us.milessmiles.imgtagger.imgtagger.model.ImageItemTag;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ImageProcessingService {

    List<ImageItemTag> getTags(String imageUrl);

}
