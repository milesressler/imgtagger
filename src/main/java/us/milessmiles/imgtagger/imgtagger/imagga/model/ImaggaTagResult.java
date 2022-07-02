package us.milessmiles.imgtagger.imgtagger.imagga.model;

import java.util.List;

public class ImaggaTagResult {
    private List<ImaggaTag> tags;
    private ImaggaStatus status;

    public List<ImaggaTag> getTags() {
        return tags;
    }

    public void setTags(List<ImaggaTag> tags) {
        this.tags = tags;
    }

    public ImaggaStatus getStatus() {
        return status;
    }

    public void setStatus(ImaggaStatus status) {
        this.status = status;
    }
}
