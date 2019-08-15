package com.coder.flickr.di.module;

import com.coder.flickr.data.network.ImagesApi;
import com.coder.flickr.data.network.NetworkDataSource;
import com.coder.flickr.di.scope.ApplicationScope;
import com.coder.flickr.di.scope.ScreenScope;
import com.coder.flickr.util.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @ApplicationScope
    @Provides
    NetworkDataSource getNetworkDataSource(ImagesApi imagesApi) {
        return new NetworkDataSource(imagesApi);
    }

    @ApplicationScope
    @Provides
    ImagesApi getImagesApi(Retrofit retrofit) {
        return retrofit.create(ImagesApi.class);
    }

    @ApplicationScope
    @Provides
    Retrofit getRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @ApplicationScope
    @Provides
    OkHttpClient getClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @ApplicationScope
    @Provides
    HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
