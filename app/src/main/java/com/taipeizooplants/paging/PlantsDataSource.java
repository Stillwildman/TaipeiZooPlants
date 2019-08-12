package com.taipeizooplants.paging;

import android.util.Log;

import com.taipeizooplants.Network.DataCallbacks;
import com.taipeizooplants.callbacks.OnDataGetCallback;
import com.taipeizooplants.callbacks.PagingStatusCallback;
import com.taipeizooplants.model.items.ItemPlants;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

public class PlantsDataSource extends PageKeyedDataSource<Integer, ItemPlants.Result.ItemPlantInfo> {

    private static final String TAG = "DataSourceZooVenue";

    private final String keyword;
    private PagingStatusCallback statusCallback;

    PlantsDataSource(String keyword, PagingStatusCallback statusCallback) {
        this.keyword = keyword;
        this.statusCallback = statusCallback;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ItemPlants.Result.ItemPlantInfo> callback) {
        int requestSize = params.requestedLoadSize;

        Log.i(TAG, "LoadInitialSize: " + requestSize);

        statusCallback.onLoading(true);

        DataCallbacks.getPlantsData(keyword, requestSize, 0, new OnDataGetCallback<ItemPlants>() {
            @Override
            public void onDataGet(ItemPlants item) {
                statusCallback.onLoading(false);

                Integer nextPageKey = item.getResult().getLimit() < item.getResult().getCount() ? item.getResult().getLimit() : null;

                Log.i(TAG, "LoadInitial NextPageKey: " + nextPageKey);

                callback.onResult(item.getResult().getPlantInfoList(), null, nextPageKey);
            }

            @Override
            public void onDataGetFailed(String errorMessage) {
                Log.e(TAG, errorMessage);
                statusCallback.onLoading(false);
                statusCallback.onFailed("LoadInitial: " + errorMessage);
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ItemPlants.Result.ItemPlantInfo> callback) {
        Log.i(TAG, "LoadBefore key: " + params.key + " RequestLoadSize: " + params.requestedLoadSize);

        statusCallback.onLoading(true);

        DataCallbacks.getPlantsData(keyword, params.requestedLoadSize, params.key, new OnDataGetCallback<ItemPlants>() {
            @Override
            public void onDataGet(ItemPlants item) {
                statusCallback.onLoading(false);

                Integer key = params.key == 0 ? null : params.key - item.getResult().getLimit();

                callback.onResult(item.getResult().getPlantInfoList(), key);
            }

            @Override
            public void onDataGetFailed(String errorMessage) {
                Log.e(TAG, errorMessage);
                statusCallback.onLoading(false);
                statusCallback.onFailed("LoadBefore: " + errorMessage);
            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ItemPlants.Result.ItemPlantInfo> callback) {
        Log.i(TAG, "LoadAfter key: " + params.key + " RequestLoadSize: " + params.requestedLoadSize);

        statusCallback.onLoading(true);

        DataCallbacks.getPlantsData(keyword, params.requestedLoadSize, params.key, new OnDataGetCallback<ItemPlants>() {
            @Override
            public void onDataGet(ItemPlants item) {
                statusCallback.onLoading(false);

                Integer nextPageKey = item.getResult().getCount() - params.key > params.requestedLoadSize ? params.key + params.requestedLoadSize : null;

                callback.onResult(item.getResult().getPlantInfoList(), nextPageKey);
            }

            @Override
            public void onDataGetFailed(String errorMessage) {
                Log.e(TAG, errorMessage);
                statusCallback.onLoading(false);
                statusCallback.onFailed("LoadAfter: " + errorMessage);
            }
        });
    }
}
