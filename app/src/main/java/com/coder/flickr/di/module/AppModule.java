package com.coder.flickr.di.module;

import android.content.Context;

import com.coder.flickr.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @ApplicationScope
    @Provides
    public Context getContext() {
        return context;
    }
}
