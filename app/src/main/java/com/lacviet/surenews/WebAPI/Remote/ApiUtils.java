package com.lacviet.surenews.WebAPI.Remote;



public class ApiUtils {


    private ApiUtils() {
    }

    public static final String BASE_URL = "http://congthongtin.bioportal.vn/API/";

    public static ApiService getSOService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
