package com.tdn.data.service;


import com.tdn.domain.serialize.req.RequestPostUpdateLocation;
import com.tdn.domain.serialize.res.ResponseAction;
import com.tdn.domain.serialize.res.ResponseGetLokasi;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    String BASE = "http://192.168.100.5/pemantauan/";
    String BASE_URL = BASE + "api/v1/";
    String BASE_URL_IMAGE = BASE + "assets/pengaduan/";
    String USER_KEY = "";

    String accept_urlencoded = "Content-Type: application/x-www-form-urlencoded";
    String accept_json = "Accept: application/json;charset=utf-8";
    String content_type = "Content-Type: application/json;charset=utf-8";
    String api_key = "X-API-KEY: your api key";


    @Headers({accept_json, content_type, api_key})
    @GET("lokasi/user")
    Call<ResponseGetLokasi> getAllLokasi();

    @Headers({accept_json, content_type, api_key})
    @POST("user/location")
    Call<ResponseAction> updateLocation(@Body RequestPostUpdateLocation req);

    class Factory {
        public static ApiService create() {
            return ServiceFactory.createService(ApiService.class);
        }
    }
}
