package us.milessmiles.imgtagger.imgtagger.contract;

public class UploadRequest {
    private String imageUrl;
    private String name;
    private Boolean objectDetection;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getObjectDetection() {
        return objectDetection;
    }

    public void setObjectDetection(Boolean objectDetection) {
        this.objectDetection = objectDetection;
    }
}
