package com.taipeizooplants.paging;

import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.model.PageConfigParams;
import com.taipeizooplants.model.items.ItemZooVenue;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class ZooVenueRepo implements PageConfigParams {

    private PagingStatusCallback statusCallback;

    public ZooVenueRepo(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    public LiveData<PagedList<ItemZooVenue.Result.ItemVenueInfo>> getZooVenueList() {
        return new LivePagedListBuilder<>(new ZooVenueDataSourceFactory(statusCallback), CONFIG)
                .setInitialLoadKey(INITIAL_LOAD_KEY)
                .build();
    }
}
