package com.sunnycorps.network.services;


import com.sunnycorps.network.models.Customer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CustomerServices {

    @GET("users/{id}")
    Call<Customer> getCustomerById(@Path("id") String id);
}
