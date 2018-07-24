package com.lacviet.surenews.WebAPI.Remote;

import com.lacviet.surenews.WebAPI.ModelAPI.AllCategoryJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.AllNewsJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.DetailJsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiService {

    @GET("EventCategory/getall")
    Call<AllCategoryJsonResponse> getAllCategorys(@Query("hasAdd") Boolean hasAdd);
    @GET("News/GetPaging")
    Call<AllNewsJsonResponse> getAllNewsByPage(@Query("categoryid") String categoryid,
                                         @Query("pageindex") int pageindex,
                                         @Query("pagesize") int pagesize);
    @GET("News/GetById")
    Call<DetailJsonResponse> getDetailbyId(@Query("id") String id);



}
