package com.taipeizooplants.viewmodel.livedata;

import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.model.items.ItemZooVenue;
import com.taipeizooplants.paging.ZooVenueRepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class ZooVenueViewModel extends ViewModel {

    private PagingStatusCallback statusCallback;

    public void setStatusCallback(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    public LiveData<PagedList<ItemZooVenue.Result.ItemVenueInfo>> getVenueList() {
        return new ZooVenueRepo(statusCallback).getZooVenueList();
    }
}
