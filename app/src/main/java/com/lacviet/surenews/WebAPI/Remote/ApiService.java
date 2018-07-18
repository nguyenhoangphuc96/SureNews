package com.lacviet.surenews.WebAPI.Remote;

import com.lacviet.surenews.WebAPI.ModelAPI.AllCategoryJsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiService {

    @GET("EventCategory/getall")
    Call<AllCategoryJsonResponse> getAllCategorys();



}
