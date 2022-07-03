package us.milessmiles.imgtagger.imgtagger.service;

import us.milessmiles.imgtagger.imgtagger.model.ImageItemTag;

import java.util.List;

public interface ImageProcessingService {

    List<ImageItemTag> getTags(String imageUrl);

}
