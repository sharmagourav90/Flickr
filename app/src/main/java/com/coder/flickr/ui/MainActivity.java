package com.coder.flickr.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coder.flickr.R;
import com.coder.flickr.ui.images.ImagesFragment;

public class MainActivity extends AppCompatActivity {
    private static final String IMAGES_TAG = "IMAGES_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImagesFragment fragment = (ImagesFragment) getSupportFragmentManager().findFragmentByTag(IMAGES_TAG);

        if (fragment == null) {
            fragment = new ImagesFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, IMAGES_TAG).commit();
        }
    }
}
