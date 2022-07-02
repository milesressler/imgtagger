package us.milessmiles.imgtagger.imgtagger.model;

public class ImageItemTag {

    private String tag;
    private Float confidence;

    public ImageItemTag(String tag, Float confidence) {
        this.tag = tag;
        this.confidence = confidence;
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
