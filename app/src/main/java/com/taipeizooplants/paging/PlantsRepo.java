package com.taipeizooplants.paging;

import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.model.PageConfigParams;
import com.taipeizooplants.model.items.ItemPlants;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class PlantsRepo implements PageConfigParams {

    private final String keyword;
    private PagingStatusCallback statusCallback;

    public PlantsRepo(String keyword, PagingStatusCallback statusCallback) {
        this.keyword = keyword;
        this.statusCallback = statusCallback;
    }

    public LiveData<PagedList<ItemPlants.Result.ItemPlantInfo>> getPlantsList() {
        return new LivePagedListBuilder<>(new PlantsDataSourceFactory(keyword, statusCallback), CONFIG)
                .setInitialLoadKey(INITIAL_LOAD_KEY)
                .build();
    }
}
