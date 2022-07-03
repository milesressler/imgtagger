package us.milessmiles.imgtagger.imgtagger.model;

import org.springframework.data.mongodb.core.index.Indexed;
import us.milessmiles.imgtagger.imgtagger.contract.ImageItemResponse;
import us.milessmiles.imgtagger.imgtagger.contract.ImageItemTagResponse;

public class ImageItemTag {


    @Indexed
    private String tag;
    private Float confidence;

    public ImageItemTag(String tag, Float confidence) {
        this.tag = tag;
        this.confidence = confidence;
    }

    public ImageItemTagResponse toResponse() {
        return new ImageItemTagResponse(tag, confidence);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }
}
