package com.taipeizooplants.ui.fragments;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.AppController;
import com.taipeizooplants.R;
import com.taipeizooplants.bases.BaseFragment;
import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.databinding.FragmentZooVenueListBinding;
import com.taipeizooplants.model.items.ItemZooVenue;
import com.taipeizooplants.ui.fragments.adapters.ZooVenueListAdapter;
import com.taipeizooplants.utilities.Utility;
import com.taipeizooplants.viewmodel.ViewZooVenueInfo;
import com.taipeizooplants.viewmodel.livedata.ZooVenueViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class UiZooVenueListFragment extends BaseFragment<FragmentZooVenueListBinding> implements PagingStatusCallback {

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_zoo_venue_list;
    }

    @Override
    protected String getTitle() {
        return AppController.getInstance().getString(R.string.taipei_zoo);
    }

    @Override
    protected void init() {
        initRecycler();
    }

    private void initRecycler() {
        if (getContext() != null) {
            mBinding.recyclerZooVenue.setLayoutManager(new LinearLayoutManager(getContext()));
            mBinding.recyclerZooVenue.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
            mBinding.recyclerZooVenue.setAdapter(new ZooVenueListAdapter(this, new DiffUtil.ItemCallback<ItemZooVenue.Result.ItemVenueInfo>() {
                @Override
                public boolean areItemsTheSame(@NonNull ItemZooVenue.Result.ItemVenueInfo oldItem, @NonNull ItemZooVenue.Result.ItemVenueInfo newItem) {
                    boolean areItemsTheSame = oldItem.getId() == newItem.getId();
                    Log.i(TAG, "AreItemsTheSame: " + areItemsTheSame);
                    return areItemsTheSame;
                }

                @Override
                public boolean areContentsTheSame(@NonNull ItemZooVenue.Result.ItemVenueInfo oldItem, @NonNull ItemZooVenue.Result.ItemVenueInfo newItem) {
                    boolean areContentsTheSame = oldItem.getName().equals(newItem.getName());
                    Log.i(TAG, "AreContentsTheSame: " + areContentsTheSame);
                    return areContentsTheSame;
                }
            }));

            getZooVenueData();
        }
    }

    private void getZooVenueData() {
        LiveData<PagedList<ItemZooVenue.Result.ItemVenueInfo>> liveData = getViewModel().getVenueList();

        liveData.observe(this, venueList -> {
            if (venueList != null) {
                getAdapter().submitList(venueList);
            }
        });
    }

    private void goToVenueInfo(int position) {
        ViewZooVenueInfo venueInfo = getAdapter().getVenueInfoViewModel(position);
        goToFragmentWithAnim(UiZooVenueInfoFragment.newInstance(venueInfo), BACK_VENUE_INFO, R.anim.slide_in_from_right, R.anim.slide_out_to_right);
    }

    private ZooVenueListAdapter getAdapter() {
        return (ZooVenueListAdapter) mBinding.recyclerZooVenue.getAdapter();
    }

    private ZooVenueViewModel getViewModel() {
        ZooVenueViewModel viewModel = ViewModelProviders.of(this).get(ZooVenueViewModel.class);
        viewModel.setStatusCallback(this);
        return viewModel;
    }

    @Override
    public void onLoading(boolean isInLoading) {
        showLoadingCircle(isInLoading);
    }

    @Override
    public void onFailed(String errorMessage) {
        Utility.toastLong(errorMessage);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.layout_zooVenue) {
            goToVenueInfo((int) v.getTag());
        }
    }

    @Override
    protected void clearReferences() {

    }
}
