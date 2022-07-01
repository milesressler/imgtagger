package us.milessmiles.imgtagger.imgtagger.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import us.milessmiles.imgtagger.imgtagger.model.ImageItem;

public interface ImageItemRepository extends MongoRepository<ImageItem, String> {

    @Query("{name: '?0'}")
    ImageItem findImageItemByName(String name);
}
