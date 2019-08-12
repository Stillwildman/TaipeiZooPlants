package com.taipeizooplants.viewmodel.livedata;

import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.model.items.ItemPlants;
import com.taipeizooplants.paging.PlantsRepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class PlantsViewModel extends ViewModel {

    private String keyword;
    private PagingStatusCallback statusCallback;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setStatusCallback(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    public LiveData<PagedList<ItemPlants.Result.ItemPlantInfo>> getPlantsList() {
        return new PlantsRepo(keyword, statusCallback).getPlantsList();
    }
}
