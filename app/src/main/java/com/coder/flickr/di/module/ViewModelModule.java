package com.coder.flickr.di.module;

import android.arch.lifecycle.ViewModel;

import com.coder.flickr.data.ImageRepository;
import com.coder.flickr.di.ViewModelFactory;
import com.coder.flickr.di.scope.ApplicationScope;
import com.coder.flickr.di.scope.ScreenScope;
import com.coder.flickr.ui.images.ImagesViewModel;
import com.coder.flickr.ui.images.adapter.ImagesAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class ViewModelModule {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    @ScreenScope
    @Provides
    ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelFactory(providerMap);
    }

    @ScreenScope
    @Provides
    @IntoMap
    @ViewModelKey(ImagesViewModel.class)
    ViewModel getImagesViewModel(ImageRepository repository) {
        return new ImagesViewModel(repository);
    }
}
