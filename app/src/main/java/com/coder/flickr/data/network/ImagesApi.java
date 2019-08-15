package com.coder.flickr.data.network;

import com.coder.flickr.data.model.ImagesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImagesApi {
    @GET("services/rest")
    Call<ImagesResponse> fetchPhotos(@Query("method")String method,
                                               @Query("api_key") String apiKey,
                                               @Query("format") String format,
                                               @Query("nojsoncallback") String noJsonCallback,
                                               @Query("text") String text);
}
