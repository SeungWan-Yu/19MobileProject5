package com.example.a19mobileproject5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabFragment2 extends Fragment {

    ArrayList<Stores> stores = new ArrayList<>();
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
                .baseUrl("http://openapi.seoul.go.kr:8088/526747566773657534335a636f7853/json/ListPriceModelStoreService/1/10/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<Stores>> call = requestInterface.getStoresJson();
        call.enqueue(new Callback<List<Stores>>() {
            @Override
            public void onResponse(@NonNull Call<List<Stores>> call, @NonNull Response<List<Stores>> response) {
                assert response.body() != null;
//                stores = new ArrayList<>(Objects.requireNonNull(response).body());
                storesAdaptar=new StoresAdaptar(getActivity(),stores);
                stores_recyclerview.setAdapter(storesAdaptar);
                Toast.makeText(getActivity(), "성공하였습니다", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Stores>> call, Throwable t) {
                Toast.makeText(getActivity(), "실패다", Toast.LENGTH_LONG).show();
            }
        });
    }
}