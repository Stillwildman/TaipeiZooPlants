package com.taipeizooplants.paging;

import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.model.items.ItemZooVenue;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

public class ZooVenueDataSourceFactory extends DataSource.Factory<Integer, ItemZooVenue.Result.ItemVenueInfo> {

    private PagingStatusCallback statusCallback;

    ZooVenueDataSourceFactory(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    @NonNull
    @Override
    public DataSource<Integer, ItemZooVenue.Result.ItemVenueInfo> create() {
        return new ZooVenueDataSource(statusCallback);
    }
}
