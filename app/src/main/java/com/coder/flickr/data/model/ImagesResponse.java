package com.coder.flickr.data.model;

public class ImagesResponse {
    Photos photos;
    private String stat;


    // Getter Methods

    public Photos getPhotos() {
        return photos;
    }

    public String getStat() {
        return stat;
    }

    // Setter Methods

    public void setPhotos(Photos photosObject) {
        this.photos = photosObject;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
