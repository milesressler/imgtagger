package us.milessmiles.imgtagger.imgtagger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ImageItem {
    @Id
    private String id;

    private String name;
}
