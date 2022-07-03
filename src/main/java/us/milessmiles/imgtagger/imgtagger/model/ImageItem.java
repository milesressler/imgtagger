package us.milessmiles.imgtagger.imgtagger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import us.milessmiles.imgtagger.imgtagger.contract.ImageItemResponse;

import java.util.List;

@Document(collection = "images")
public class ImageItem {

    @Id()
    private long id;

    @Indexed
    private String url;
    private String name;

    private List<ImageItemTag> tags;

    @Transient
    public static final String SEQUENCE_NAME = "images_sequence";

    public ImageItem(String url, String name, List<ImageItemTag> tags) {
        this.url = url;
        this.name = name;
        this.tags = tags;
    }

    public ImageItemResponse toResponse() {
        ImageItemResponse response = new ImageItemResponse(id, url, name,null);
        if (tags != null) {
            response.setTags(tags.stream().map(ImageItemTag::toResponse).toList());
        }
        return response;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ImageItemTag> getTags() {
        return tags;
    }

    public void setTags(List<ImageItemTag> tags) {
        this.tags = tags;
    }
}
