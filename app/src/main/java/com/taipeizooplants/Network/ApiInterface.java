package com.taipeizooplants.Network;

import com.taipeizooplants.model.ApiUrls;
import com.taipeizooplants.model.items.ItemPlants;
import com.taipeizooplants.model.items.ItemZooVenue;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET(ApiUrls.API_ZOO_VENUE_INFO)
    Call<ItemZooVenue> getVenueInfo(@Query("limit") int limit, @Query("offset") int offset);

    @GET(ApiUrls.API_PLANTS_INFO)
    Call<ItemPlants> getPlants(@Query("q") String keyword, @Query("limit") int limit, @Query("offset") int offset);
}
