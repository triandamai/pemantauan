package com.tdn.data.service;


import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.ReqAuth;
import com.tdn.domain.serialize.req.ReqPenjualan;
import com.tdn.domain.serialize.req.ReqPenjualanTemp;
import com.tdn.domain.serialize.res.ResponseAction;
import com.tdn.domain.serialize.res.ResponseAuth;
import com.tdn.domain.serialize.res.ResponseGetHome;
import com.tdn.domain.serialize.res.ResponseGetNotifikasi;
import com.tdn.domain.serialize.res.ResponseGetObat;
import com.tdn.domain.serialize.res.ResponseGetPenjualan;
import com.tdn.domain.serialize.res.ResponseGetPenjualanTemp;
import com.tdn.domain.serialize.res.ResponsePenjualanDetail;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiService {

 
    String BASE = "http://kadede-farma.000webhostapp.com/";
    String BASE_URL = BASE + "api/v1/";
    String BASE_URL_IMAGE = BASE + "assets/pengaduan/";
    String USER_KEY = "";

    String accept_urlencoded = "Content-Type: application/x-www-form-urlencoded";
    String accept_json = "Accept: application/json;charset=utf-8";
    String content_type = "Content-Type: application/json;charset=utf-8";
    String api_key = "X-API-KEY: your api key";


    @Headers({accept_json, content_type, api_key})
    @GET("user/users")
    Call<Response> getUserById(@Query("id") String id);

    class Factory {
        public static ApiService create() {
            return ServiceFactory.createService(ApiService.class);
        }
    }
}
