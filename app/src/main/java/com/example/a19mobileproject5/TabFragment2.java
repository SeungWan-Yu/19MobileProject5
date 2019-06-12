package com.example.a19mobileproject5;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a19mobileproject5.models.StoresModels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabFragment2 extends Fragment {

    private StoresAdaptar storesAdaptar;
    private RecyclerView stores_recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);

        stores_recyclerview = view.findViewById(R.id.stores_recyclerview);
        stores_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        getStoresRespons();

        return view;
    }

    private void getStoresRespons() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/526747566773657534335a636f7853/json/ListPriceModelStoreService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<StoresModels> call = requestInterface.getStoresJson();
        call.enqueue(new Callback<StoresModels>() {
            @Override
            public void onResponse(Call<StoresModels> call, Response<StoresModels> response) {
                storesAdaptar = new StoresAdaptar(getActivity(), response.body().getListPriceModelStoreService().getRow());
                stores_recyclerview.setAdapter(storesAdaptar);
                Toast.makeText(getActivity(), "성공하였습니다", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<StoresModels> call, Throwable t) {
                Toast.makeText(getActivity(), "실패다", Toast.LENGTH_LONG).show();
            }
        });

    }
}