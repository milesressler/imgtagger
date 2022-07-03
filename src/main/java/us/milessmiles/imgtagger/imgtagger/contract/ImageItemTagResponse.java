package us.milessmiles.imgtagger.imgtagger.contract;

public class ImageItemTagResponse {
    private String tag;
    private Float confidence;

    public ImageItemTagResponse(String tag, Float confidence) {
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
