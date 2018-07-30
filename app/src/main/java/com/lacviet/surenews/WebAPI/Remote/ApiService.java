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
    //
    @GET("Government/GetCategory")
    Call<AllCategoryJsonResponse> getAllCategorysGoverment();
    @GET("Government/GetNewsPaging")
    Call<AllNewsJsonResponse> getAllGovermentNewsByPage(@Query("categoryid") String categoryid,
                                               @Query("pageindex") int pageindex,
                                               @Query("pagesize") int pagesize);
    @GET("Government/GetNewsById")
    Call<DetailJsonResponse> getDetailGovernment(@Query("id") String id,
                                                 @Query("categoryid") String categoryid);
    //
    @GET("Investment/GetCategory")
    Call<AllCategoryJsonResponse> getAllCategorysDevelopment();
    @GET("Investment/GetNewsPaging")
    Call<AllNewsJsonResponse> getAllInvestmentNewsByPage(@Query("categoryid") String categoryid,
                                                        @Query("pageindex") int pageindex,
                                                        @Query("pagesize") int pagesize);
    @GET("Investment/GetNewsById")
    Call<DetailJsonResponse> getDetailInvestMent(@Query("id") String id,
                                                 @Query("categoryid") String categoryid);
    //
    @GET("Travel/GetCategory")
    Call<AllCategoryJsonResponse> getAllCategorysTravel();
    @GET("Travel/GetNewsPaging")
    Call<AllNewsJsonResponse> getAllTravelNewsByPage(@Query("categoryid") String categoryid,
                                                         @Query("pageindex") int pageindex,
                                                         @Query("pagesize") int pagesize);
    @GET("Travel/GetNewsById")
    Call<DetailJsonResponse> getDetailTravel(@Query("id") String id,
                                                 @Query("categoryid") String categoryid);



}
