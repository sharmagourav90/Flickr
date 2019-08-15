package com.coder.flickr.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingUtils {
    @BindingAdapter("app:url")
    public static void loadImage(ImageView image, String url) {
        Picasso.get()
                .load(url)
                .into(image);
        Picasso.get().setIndicatorsEnabled(true);
    }
}
