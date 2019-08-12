package com.taipeizooplants.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.taipeizooplants.R;
import com.taipeizooplants.bases.BaseFragment;
import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.databinding.FragmentZooVenueInfoBinding;
import com.taipeizooplants.model.items.ItemPlants;
import com.taipeizooplants.ui.fragments.adapters.PlantsListAdapter;
import com.taipeizooplants.utilities.Utility;
import com.taipeizooplants.viewmodel.ViewPlantsInfo;
import com.taipeizooplants.viewmodel.ViewZooVenueInfo;
import com.taipeizooplants.viewmodel.livedata.PlantsViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class UiZooVenueInfoFragment extends BaseFragment<FragmentZooVenueInfoBinding> implements PagingStatusCallback {

    private ViewZooVenueInfo venueInfo;

    static UiZooVenueInfoFragment newInstance(ViewZooVenueInfo venueInfo) {
        UiZooVenueInfoFragment instance = new UiZooVenueInfoFragment();

        Bundle arg = new Bundle();
        arg.putParcelable(BUNDLE_VENUE_INFO, venueInfo);

        instance.setArguments(arg);

        return instance;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_zoo_venue_info;
    }

    @Override
    protected String getTitle() {
        return venueInfo.getName();
    }

    @Override
    protected void init() {
        getVenueInfoFromArg();
        setInfo();
        initRecycler();
    }

    private void getVenueInfoFromArg() {
        if (getArguments() != null) {
            venueInfo = getArguments().getParcelable(BUNDLE_VENUE_INFO);
        }
    }

    private void setInfo() {
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.ic_place_holder_circle);

        Glide.with(this)
                .load(venueInfo.getPicUrl())
                .apply(options)
                .into(mBinding.imageVenuePhoto);

        mBinding.setItem(venueInfo);
    }

    private void initRecycler() {
        if (getContext() != null) {
            mBinding.recyclerPlants.setLayoutManager(new LinearLayoutManager(getContext()));
            mBinding.recyclerPlants.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
            mBinding.recyclerPlants.setAdapter(new PlantsListAdapter(this, new DiffUtil.ItemCallback<ItemPlants.Result.ItemPlantInfo>() {
                @Override
                public boolean areItemsTheSame(@NonNull ItemPlants.Result.ItemPlantInfo oldItem, @NonNull ItemPlants.Result.ItemPlantInfo newItem) {
                    boolean areItemsTheSame = oldItem.getId() == newItem.getId();
                    Log.i(TAG, "AreItemsTheSame: " + areItemsTheSame);
                    return areItemsTheSame;
                }

                @Override
                public boolean areContentsTheSame(@NonNull ItemPlants.Result.ItemPlantInfo oldItem, @NonNull ItemPlants.Result.ItemPlantInfo newItem) {
                    boolean areContentsTheSame = oldItem.getNameCh().equals(newItem.getNameCh());
                    Log.i(TAG, "AreContentsTheSame: " + areContentsTheSame);
                    return areContentsTheSame;
                }
            }));
        }

        getPlantsData();
    }

    private void getPlantsData() {
        LiveData<PagedList<ItemPlants.Result.ItemPlantInfo>> liveData = getViewModel().getPlantsList();

        liveData.observe(this, plantsList -> {
            if (plantsList != null) {
                getAdapter().submitList(plantsList);
            }
        });
    }

    private void goToPlantsInfo(int position) {
        ViewPlantsInfo plantsInfo = getAdapter().getPlantsInfoViewModel(position);
        goToFragmentWithAnim(UiPlantsInfoFragment.newInstance(plantsInfo), BACK_PLANTS, R.anim.slide_in_from_top, R.anim.slide_out_to_top);
    }

    private PlantsListAdapter getAdapter() {
        return (PlantsListAdapter) mBinding.recyclerPlants.getAdapter();
    }

    private PlantsViewModel getViewModel() {
        PlantsViewModel viewModel = ViewModelProviders.of(this).get(PlantsViewModel.class);

        viewModel.setKeyword(venueInfo.getName());
        viewModel.setStatusCallback(this);

        return viewModel;
    }

    @Override
    public void onLoading(boolean isInLoading) {
        showLoadingCircle(isInLoading);

        if (!isInLoading) {
            mBinding.loadingCirclePlants.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailed(String errorMessage) {
        Utility.toastLong(errorMessage);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.layout_plants) {
            goToPlantsInfo((int) v.getTag());
        }
    }

    @Override
    protected void clearReferences() {
        venueInfo = null;
    }
}
