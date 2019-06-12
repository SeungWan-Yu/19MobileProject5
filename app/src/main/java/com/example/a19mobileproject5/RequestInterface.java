package com.example.a19mobileproject5;

import com.example.a19mobileproject5.models.StoresModels;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterface {
    @GET("1/5/")
    Call<StoresModels> getStoresJson();
}
