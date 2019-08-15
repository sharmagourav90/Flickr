package com.coder.flickr.ui.images;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.coder.flickr.FlickrApp;
import com.coder.flickr.R;
import com.coder.flickr.data.model.ImagesResponse;
import com.coder.flickr.databinding.ImagesFragmentBinding;
import com.coder.flickr.di.ViewModelFactory;
import com.coder.flickr.di.component.ImageComponent;
import com.coder.flickr.di.module.AdapterModule;
import com.coder.flickr.di.module.ViewModelModule;
import com.coder.flickr.ui.images.adapter.ImagesAdapter;
import com.coder.flickr.util.Constants;

import javax.inject.Inject;

import static com.coder.flickr.util.Constants.GRID_SIZE;

public class ImagesFragment extends Fragment {
    private final String TAG = ImagesFragment.class.getSimpleName();

    @Inject
    ViewModelFactory mViewModelFactory;

    private ImagesViewModel mViewModel;
    private RecyclerView mGridImages;

    private ImagesAdapter mAdapter;

    private ImageComponent mImageComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

            ((FlickrApp) getActivity().getApplication()).getAppComponent().
                    getImageComponent(new AdapterModule(), new ViewModelModule()).inject(this);

//        mImageComponent = ((FlickrApp) getActivity().getApplication()).getAppComponent().
//                getImageComponent(new AdapterModule(), new ViewModelModule());
//
//        mImageComponent.inject(this);


        Log.e("Test", "mViewModelFactory " + mViewModelFactory);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
                             @Nullable Bundle savedInstanceState) {
        ImagesFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.images_fragment, parent, false);
        mGridImages = binding.gridImages;

        Toolbar toolbar = (Toolbar) binding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        mGridImages.setLayoutManager(new GridLayoutManager(getActivity(), GRID_SIZE));

        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ImagesViewModel.class);

        mAdapter = new ImagesAdapter();

        if(mViewModel.getImages() != null)
            mAdapter.setPhotos(mViewModel.getImages().getValue().getPhotos());

        Log.d(TAG, mViewModelFactory + "");

        mGridImages.setAdapter(mAdapter);

        if (savedInstanceState == null) {
            serachImages(Constants.INITIAL_QUERY);
        }
    }

    private void serachImages(String text) {
        mViewModel.fetchImages(text);
        mViewModel.getImages().observe(this, new Observer<ImagesResponse>() {
            @Override
            public void onChanged(@Nullable ImagesResponse imagesResponse) {
                Log.i(TAG, "onChanged");
                if (imagesResponse != null && imagesResponse.getPhotos() != null) {
                    mAdapter.setPhotos(imagesResponse.getPhotos());
                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                serachImages(text);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        ((FlickrApp) getActivity().getApplication()).clearImageComponent();
    }
}
