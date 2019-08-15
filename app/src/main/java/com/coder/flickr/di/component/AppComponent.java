package com.coder.flickr.di.component;

import com.coder.flickr.FlickrApp;
import com.coder.flickr.di.module.AdapterModule;
import com.coder.flickr.di.module.AppModule;
import com.coder.flickr.di.module.NetworkModule;
import com.coder.flickr.di.module.RepositoryModule;
import com.coder.flickr.di.module.ViewModelModule;
import com.coder.flickr.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class, NetworkModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(FlickrApp app);

    ImageComponent getImageComponent(AdapterModule adapterModule, ViewModelModule viewModelModule);
}
