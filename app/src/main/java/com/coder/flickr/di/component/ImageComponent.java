package com.coder.flickr.di.component;

import com.coder.flickr.di.module.AdapterModule;
import com.coder.flickr.di.module.ViewModelModule;
import com.coder.flickr.di.scope.ScreenScope;
import com.coder.flickr.ui.images.ImagesFragment;

import dagger.Subcomponent;

@ScreenScope
@Subcomponent(modules = {AdapterModule.class, ViewModelModule.class})
public interface ImageComponent {
    void inject(ImagesFragment fragment);
}
