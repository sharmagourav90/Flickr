package com.coder.flickr.di.module;

import com.coder.flickr.di.scope.ScreenScope;
import com.coder.flickr.ui.images.adapter.ImagesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {
    @ScreenScope
    @Provides
    ImagesAdapter getAdapter() {
        return new ImagesAdapter();
    }
}
