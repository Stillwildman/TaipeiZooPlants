package com.taipeizooplants.Network;

import android.util.Log;

import com.taipeizooplants.callbacks.OnDataGetCallback;
import com.taipeizooplants.model.ApiUrls;
import com.taipeizooplants.model.items.ItemPlants;
import com.taipeizooplants.model.items.ItemZooVenue;
import com.taipeizooplants.utilities.DialogHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class DataCallbacks implements ApiUrls {

    private static final String TAG = "DataCallbacks";

    private static ApiInterface getApiInterface(String baseUrl) {
        return WebAgent.getRetrofit(baseUrl).create(ApiInterface.class);
    }

    private static<Item> void enqueue(Call<Item> call, final OnDataGetCallback<Item> dataGet) {
        Log.i(TAG, "Call URL: " + call.request().url().toString());

        call.enqueue(new Callback<Item>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Log.d(TAG, "Call onResponse!!! "
                        + "\nMessage: " + response.message()
                        + " IsSuccessful: " + response.isSuccessful());

                DialogHelper.dismissDialog();

                if (response.isSuccessful()) {
                    dataGet.onDataGet(response.body());
                }
                else {
                    dataGet.onDataGetFailed(response.message());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.e(TAG, "Call onFailure!!!\n" + t.getMessage());
                DialogHelper.dismissDialog();

                dataGet.onDataGetFailed(t.getMessage());
            }
        });
    }

    public static void getZooVenueData(int limit, int offset, final OnDataGetCallback<ItemZooVenue> dataGet) {
        Call<ItemZooVenue> call = getApiInterface(BASE_TAIPEI_OPEN_DATA).getVenueInfo(limit, offset);

        enqueue(call, dataGet);
    }

    public static void getPlantsData(String keyword, int limit, int offset, final OnDataGetCallback<ItemPlants> dataGet) {
        Call<ItemPlants> call = getApiInterface(BASE_TAIPEI_OPEN_DATA).getPlants(keyword, limit, offset);

        enqueue(call, dataGet);
    }
}
