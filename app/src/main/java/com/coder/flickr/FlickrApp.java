package com.coder.flickr;

import android.app.Application;

import com.coder.flickr.di.component.AppComponent;
import com.coder.flickr.di.component.DaggerAppComponent;
import com.coder.flickr.di.component.ImageComponent;
import com.coder.flickr.di.module.AdapterModule;
import com.coder.flickr.di.module.AppModule;
import com.coder.flickr.di.module.NetworkModule;
import com.coder.flickr.di.module.RepositoryModule;
import com.coder.flickr.di.module.ViewModelModule;
import com.squareup.leakcanary.LeakCanary;

public class FlickrApp extends Application {
    private AppComponent mAppComponent;
    private ImageComponent mImageComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);

        mAppComponent = DaggerAppComponent.builder().
                appModule(new AppModule(this)).
                networkModule(new NetworkModule()).
                repositoryModule(new RepositoryModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public ImageComponent getImageComponent() {
        if(mImageComponent == null) {
            mImageComponent = getAppComponent().
                    getImageComponent(new AdapterModule(), new ViewModelModule());
        }
        return mImageComponent;
    }

    public void clearImageComponent() {
        mImageComponent = null;
    }
}
