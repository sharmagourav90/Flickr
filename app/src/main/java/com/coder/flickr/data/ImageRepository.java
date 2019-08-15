package com.coder.flickr.data;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.coder.flickr.data.model.ImagesResponse;
import com.coder.flickr.data.network.NetworkDataSource;

import javax.inject.Inject;

public class ImageRepository {
    private NetworkDataSource networkDataSource;

    @Inject
    public ImageRepository(NetworkDataSource source) {

        Log.e("Test", "source " + source);
        networkDataSource = source;
    }

    public MutableLiveData<ImagesResponse> loadImages(String text) {
        Log.e("Test", "source " + networkDataSource);
        return networkDataSource.loadImages(text);
    }
}
