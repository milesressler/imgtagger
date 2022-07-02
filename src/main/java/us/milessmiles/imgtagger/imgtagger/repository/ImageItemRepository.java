package us.milessmiles.imgtagger.imgtagger.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import us.milessmiles.imgtagger.imgtagger.model.ImageItem;

import java.util.List;
import java.util.Optional;

public interface ImageItemRepository extends MongoRepository<ImageItem, Long> {

    List<ImageItem> findByTagsTag(String tag);
    List<ImageItem> findByTagsTagAndTagsConfidenceGreaterThan(String tag, Float confidence);
}
