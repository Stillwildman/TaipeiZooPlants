package com.taipeizooplants.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.taipeizooplants.R;
import com.taipeizooplants.bases.BaseFragment;
import com.taipeizooplants.databinding.FragmentPlantsInfoBinding;
import com.taipeizooplants.viewmodel.ViewPlantsInfo;

public class UiPlantsInfoFragment extends BaseFragment<FragmentPlantsInfoBinding> {

    private ViewPlantsInfo plantsInfo;

    public static UiPlantsInfoFragment newInstance(ViewPlantsInfo plantsInfo) {
        UiPlantsInfoFragment instance = new UiPlantsInfoFragment();

        Bundle arg = new Bundle();
        arg.putParcelable(BUNDLE_PLANTS_INFO, plantsInfo);

        instance.setArguments(arg);

        return instance;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_plants_info;
    }

    @Override
    protected String getTitle() {
        return plantsInfo.getNameCh();
    }

    @Override
    protected void init() {
        getPlantsInfoFromArg();
        setInfo();
    }

    private void getPlantsInfoFromArg() {
        if (getArguments() != null) {
            plantsInfo = getArguments().getParcelable(BUNDLE_PLANTS_INFO);
        }
    }

    private void setInfo() {
        if (!plantsInfo.getPicUrl().isEmpty()) {
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.ic_place_holder_circle).centerCrop();

            Glide.with(this)
                    .load(plantsInfo.getPicUrl())
                    .apply(options)
                    .into(mBinding.imagePlantsPhoto);
        }
        mBinding.setItem(plantsInfo);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void clearReferences() {
        plantsInfo = null;
    }
}
