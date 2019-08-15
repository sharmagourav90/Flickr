package com.coder.flickr.di.module;

import com.coder.flickr.data.ImageRepository;
import com.coder.flickr.data.model.ImagesResponse;
import com.coder.flickr.data.network.NetworkDataSource;
import com.coder.flickr.di.scope.ApplicationScope;
import com.coder.flickr.di.scope.ScreenScope;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @ApplicationScope
    @Provides
    ImageRepository getRepository(NetworkDataSource source) {
        return new ImageRepository(source);
    }
}
