package us.milessmiles.imgtagger.imgtagger.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import us.milessmiles.imgtagger.imgtagger.model.ImageItem;

import java.util.Optional;

public interface ImageItemRepository extends MongoRepository<ImageItem, Long> {

    Page<ImageItem> findByTagsTag(Pageable pageable, String tag);
    Optional<ImageItem> findFirstByUrl(String url);
    Page<ImageItem> findByTagsTagAndTagsConfidenceGreaterThan(Pageable pageable, String tag, Float confidence);
}
