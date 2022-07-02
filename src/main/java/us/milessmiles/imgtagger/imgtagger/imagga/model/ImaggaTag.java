package us.milessmiles.imgtagger.imgtagger.imagga.model;

import java.util.Map;

public class ImaggaTag {
    private Float confidence;
    private Map<String, String> tag;

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    public Map<String, String> getTag() {
        return tag;
    }

    public void setTag(Map<String, String> tag) {
        this.tag = tag;
    }
}
