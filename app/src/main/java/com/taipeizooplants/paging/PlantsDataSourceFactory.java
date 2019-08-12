package com.taipeizooplants.paging;

import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.model.items.ItemPlants;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

public class PlantsDataSourceFactory extends DataSource.Factory<Integer, ItemPlants.Result.ItemPlantInfo> {

    private final String keyword;
    private PagingStatusCallback statusCallback;

    PlantsDataSourceFactory(String keyword, PagingStatusCallback statusCallback) {
        this.keyword = keyword;
        this.statusCallback = statusCallback;
    }

    @NonNull
    @Override
    public DataSource<Integer, ItemPlants.Result.ItemPlantInfo> create() {
        return new PlantsDataSource(keyword, statusCallback);
    }
}
