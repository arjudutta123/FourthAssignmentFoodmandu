package com.arju.foodmandu.api;

import com.arju.foodmandu.model.Alcohol;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlcoholApi {

    @GET("alcohol")
    Call<List<Alcohol>> getAlcohol();

}
