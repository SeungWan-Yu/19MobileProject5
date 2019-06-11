package com.example.a19mobileproject5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterface {
    @GET("/")
    Call<List<Stores>> getStoresJson();
}
