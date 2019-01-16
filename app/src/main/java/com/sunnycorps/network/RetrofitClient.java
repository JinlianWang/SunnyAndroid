package com.sunnycorps.network;

import android.util.Log;

import com.sunnycorps.network.models.Customer;
import com.sunnycorps.network.services.CustomerServices;

import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private Retrofit retrofit = null;

    private static final RetrofitClient instance = new RetrofitClient();

    //private constructor to avoid client applications to use constructor
    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance(){
        return instance;
    }

    private CustomerServices getCustomerServices(){
        return retrofit.create(CustomerServices.class);
    }

    public void getCustomerById(String id, Callback<Customer> customerCallback){
        Call<Customer> call = RetrofitClient.getInstance().getCustomerServices().getCustomerById(id);
        call.enqueue(customerCallback);
    }
}
