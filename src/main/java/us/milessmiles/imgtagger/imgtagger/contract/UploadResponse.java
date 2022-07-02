package us.milessmiles.imgtagger.imgtagger.contract;

import us.milessmiles.imgtagger.imgtagger.model.ImageItem;

public class UploadResponse {
    private boolean success;
    private ImageItem imageItem;

    public UploadResponse(boolean success, ImageItem imageItem) {
        this.success = success;
        this.imageItem = imageItem;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ImageItem getImageItem() {
        return imageItem;
    }

    public void setImageItem(ImageItem imageItem) {
        this.imageItem = imageItem;
    }
}
