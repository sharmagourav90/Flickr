package com.coder.flickr.data.model;

import java.util.ArrayList;

public class Photos {
    private float page;
    private float pages;
    private float perpage;
    private String total;
    ArrayList<Photo> photo = new ArrayList<>();


    // Getter Methods

    public ArrayList<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<Photo> photo) {
        this.photo = photo;
    }

    public float getPage() {
        return page;
    }

    public float getPages() {
        return pages;
    }

    public float getPerpage() {
        return perpage;
    }

    public String getTotal() {
        return total;
    }

    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setPages(float pages) {
        this.pages = pages;
    }

    public void setPerpage(float perpage) {
        this.perpage = perpage;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
