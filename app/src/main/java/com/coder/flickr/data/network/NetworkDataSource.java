package com.coder.flickr.data.network;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.coder.flickr.data.model.ImagesResponse;
import com.coder.flickr.util.Constants;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkDataSource {
    private ImagesApi mImagesApi;

    @Inject
    public NetworkDataSource(ImagesApi imagesApi) {
        Log.e("Test", "imagesApi - " + imagesApi);
        mImagesApi = imagesApi;
    }

    public MutableLiveData<ImagesResponse> loadImages(String text) {
        final MutableLiveData<ImagesResponse> responseLiveData = new MutableLiveData<>();

        Call<ImagesResponse> call = mImagesApi.fetchPhotos(Constants.METHOD, Constants.API_KEY, Constants.FORMAT, Constants.NO_JSON_CALLBACK, text);
        call.enqueue(new Callback<ImagesResponse>() {
            @Override
            public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                responseLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ImagesResponse> call, Throwable t) {
            }
        });
        return responseLiveData;
    }
}
