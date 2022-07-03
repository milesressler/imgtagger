package us.milessmiles.imgtagger.imgtagger.contract;

import java.util.List;

public class ImageItemResponse {


    private long id;
    private String url;
    private String name;
    private List<ImageItemTagResponse> tags;

    public ImageItemResponse(long id, String url, String name, List<ImageItemTagResponse> tags) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageItemTagResponse> getTags() {
        return tags;
    }

    public void setTags(List<ImageItemTagResponse> tags) {
        this.tags = tags;
    }
}


