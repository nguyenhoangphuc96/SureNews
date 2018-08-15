package com.lacviet.surenews.WebAPI.Remote;


import com.lacviet.surenews.ConfigActivity;

public class ApiUtils {


    private ApiUtils() {
    }

    public static final String BASE_URL = "http://"+ ConfigActivity.configUrl + "/api/";

    public static ApiService getSOService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
