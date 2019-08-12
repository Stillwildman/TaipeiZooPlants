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
import com.taipeizooplants.databinding.InflatePlantsBinding;
import com.taipeizooplants.model.items.ItemPlants;
import com.taipeizooplants.utilities.Utility;
import com.taipeizooplants.viewmodel.ViewPlantsInfo;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PlantsListAdapter extends BaseBindingRecycler<ItemPlants.Result.ItemPlantInfo, InflatePlantsBinding> {

    private View.OnClickListener clickListener;
    private final int photoHeight;
    private final RequestOptions options;

    public PlantsListAdapter(View.OnClickListener clickListener, @NonNull DiffUtil.ItemCallback<ItemPlants.Result.ItemPlantInfo> diffCallback) {
        super(diffCallback);

        this.clickListener = clickListener;
        photoHeight = (Utility.getScreenHeight() - Utility.getActionbarHeight()) / 8;
        this.options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).fitCenter().placeholder(R.drawable.ic_place_holder_circle);

        Log.i(TAG, "Plants Photo Height: " + photoHeight);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.inflate_plants;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        InflatePlantsBinding bindingView = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutId(), parent, false);
        return new PlantsViewHolder(bindingView);
    }

    class PlantsViewHolder extends BindingViewHolder {

        PlantsViewHolder(InflatePlantsBinding inflatePlantsBinding) {
            super(inflatePlantsBinding);

            bindingView.imagePlantsPhoto.getLayoutParams().height = photoHeight;
            bindingView.getRoot().setOnClickListener(clickListener);
        }

        private void setPhotoByUrl(String url) {
            if (url != null && !url.isEmpty()) {
                Glide.with(itemView)
                        .load(url)
                        .apply(options)
                        .into(bindingView.imagePlantsPhoto);
            }
        }
    }

    @Override
    protected void onBindingViewHolder(RecyclerView.ViewHolder holder, InflatePlantsBinding bindingView, int position) {
        bindingView.getRoot().setTag(position);

        ViewPlantsInfo plantsInfo = getPlantsInfoViewModel(position);

        if (plantsInfo != null) {
            bindingView.setItem(plantsInfo);
            ((PlantsViewHolder) holder).setPhotoByUrl(plantsInfo.getPicUrl());
        }
    }

    @Override
    protected void onBindingViewHolder(RecyclerView.ViewHolder holder, InflatePlantsBinding bindingView, int position, Object payload) {

    }

    public ViewPlantsInfo getPlantsInfoViewModel(int position) {
        ItemPlants.Result.ItemPlantInfo item = getItem(position);

        if (item != null) {
            return new ViewPlantsInfo(item.getNameCh(), item.getNameEn(), item.getAlsoKnown(),
                    item.getBrief(), item.getFeature(), item.getFunction(), item.getUpdate(), item.getPicUrl());
        }
        else {
            return null;
        }
    }
}
