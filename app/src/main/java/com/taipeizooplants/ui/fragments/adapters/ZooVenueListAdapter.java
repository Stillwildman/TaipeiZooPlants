package com.taipeizooplants.ui.fragments.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.taipeizooplants.R;
import com.taipeizooplants.bases.BaseBindingRecycler;
import com.taipeizooplants.databinding.InflateZooVenueBinding;
import com.taipeizooplants.model.items.ItemZooVenue;
import com.taipeizooplants.utilities.Utility;
import com.taipeizooplants.viewmodel.ViewZooVenueInfo;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ZooVenueListAdapter extends BaseBindingRecycler<ItemZooVenue.Result.ItemVenueInfo, InflateZooVenueBinding> {

    private View.OnClickListener clickListener;
    private final int photoHeight;
    private final RequestOptions options;

    public ZooVenueListAdapter(View.OnClickListener clickListener, @NonNull DiffUtil.ItemCallback<ItemZooVenue.Result.ItemVenueInfo> diffCallback) {
        super(diffCallback);

        this.clickListener = clickListener;
        photoHeight = (Utility.getScreenHeight() - Utility.getActionbarHeight()) / 5;
        this.options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).fitCenter().placeholder(R.drawable.ic_place_holder_circle);

        Log.i(TAG, "ZooVenue Photo Height: " + photoHeight);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.inflate_zoo_venue;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        InflateZooVenueBinding bindingView = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutId(), parent, false);
        return new ZooVenueViewHolder(bindingView);
    }

    class ZooVenueViewHolder extends BindingViewHolder {

        ZooVenueViewHolder(InflateZooVenueBinding bindingView) {
            super(bindingView);
            bindingView.imageVenuePhoto.getLayoutParams().height = photoHeight;
            bindingView.getRoot().setOnClickListener(clickListener);
        }

        private void setPhotoByUrl(String url) {
            Glide.with(itemView)
                    .load(url)
                    .apply(options)
                    .into(bindingView.imageVenuePhoto);
        }
    }

    @Override
    protected void onBindingViewHolder(RecyclerView.ViewHolder holder, InflateZooVenueBinding bindingView, int position) {
        bindingView.getRoot().setTag(position);

        ViewZooVenueInfo venueInfo = getVenueInfoViewModel(position);

        if (venueInfo != null) {
            bindingView.setItem(venueInfo);
            ((ZooVenueViewHolder) holder).setPhotoByUrl(venueInfo.getPicUrl());
        }
    }

    @Override
    protected void onBindingViewHolder(RecyclerView.ViewHolder holder, InflateZooVenueBinding bindingView, int position, Object payload) {

    }

    public ViewZooVenueInfo getVenueInfoViewModel(int position) {
        ItemZooVenue.Result.ItemVenueInfo item = getItem(position);

        if (item != null) {
            return new ViewZooVenueInfo(item.getName(), item.getInfo(), item.getMemo(), item.getCategory(), item.getPicUrl(), item.getUrl());
        }
        else {
            return null;
        }
    }
}
