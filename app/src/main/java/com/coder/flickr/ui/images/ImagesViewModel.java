package com.coder.flickr.ui.images;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.coder.flickr.data.ImageRepository;
import com.coder.flickr.data.model.ImagesResponse;
import com.coder.flickr.ui.images.adapter.ImagesAdapter;

import javax.inject.Inject;

public class ImagesViewModel extends ViewModel {
    private MutableLiveData<ImagesResponse> response;
    private ImageRepository repository;



    @Inject
    public ImagesViewModel(ImageRepository repository) {
        Log.e("Test", "repository " + repository);
        this.repository = repository;
    }

    public void fetchImages(String text) {
        Log.e("Test", "repository " + repository);
        response = repository.loadImages(text);
    }

    public LiveData<ImagesResponse> getImages() {
        return response;
    }
}
