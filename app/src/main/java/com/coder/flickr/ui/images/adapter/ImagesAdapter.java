package com.coder.flickr.ui.images.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.coder.flickr.R;
import com.coder.flickr.data.model.Photo;
import com.coder.flickr.data.model.Photos;
import com.coder.flickr.databinding.ImageItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageHolder> {
    private final String TAG = ImagesAdapter.class.getSimpleName();
    private List<Photo> mPhotos;
    private LayoutInflater layoutInflater;

    public ImagesAdapter() {
        mPhotos = new ArrayList<>();
    }

    public void setPhotos(Photos photos) {
        Log.i(TAG, "setPhotos " + photos.getPhoto().size());
        mPhotos.clear();
        mPhotos.addAll(photos.getPhoto());
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        ImageItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.image_item, parent, false);
//        View view = layoutInflater.inflate(R.layout.image_item, parent, false);
        return new ImageHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder imageHolder, int pos) {
        imageHolder.itemBinding.setPhoto(mPhotos.get(pos));
    }

    @Override
    public int getItemCount() {
        return (mPhotos.size());
    }

    static class ImageHolder extends RecyclerView.ViewHolder {
        private ImageItemBinding itemBinding;

        public ImageHolder(@NonNull ImageItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }
    }
}
