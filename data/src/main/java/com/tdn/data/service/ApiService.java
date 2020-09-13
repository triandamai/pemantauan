package com.tdn.data.service;


import com.tdn.domain.model.PegawaiModel;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.RequestPostLaporan;
import com.tdn.domain.serialize.req.RequestPostLogin;
import com.tdn.domain.serialize.req.RequestPostUpdateLocation;
import com.tdn.domain.serialize.req.RequestPostUpdateProfil;
import com.tdn.domain.serialize.req.RequestPostUpdatepassword;
import com.tdn.domain.serialize.res.ResponseAction;
import com.tdn.domain.serialize.res.ResponseAuthLogin;
import com.tdn.domain.serialize.res.ResponseGetAbsensiNama;
import com.tdn.domain.serialize.res.ResponseGetJumlahBelumMasuk;
import com.tdn.domain.serialize.res.ResponseGetJumlahMasuk;
import com.tdn.domain.serialize.res.ResponseGetJumlahPegawai;
import com.tdn.domain.serialize.res.ResponseGetLaporan;
import com.tdn.domain.serialize.res.ResponseGetLokasi;
import com.tdn.domain.serialize.res.ResponseGetPegawai;
import com.tdn.domain.serialize.res.ResponseGetTitik;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
public interface ApiService {


    String BASEGATSU = " https://gatsu109.id/e-presensi/api/";
    //String BASE = "http://192.168.42.56/pemantauan_api/";
    String BASE = "https://gatsu109.id/lokasi/";
    String BASE_URL = BASE + "api/v1/";
    String BASE_URL_IMAGE = BASE + "public/";
    String USER_KEY = "";

    String accept_urlencoded = "Content-Type: application/x-www-form-urlencoded";
    String accept_json = "Accept: application/json;charset=utf-8";
    String content_type = "Content-Type: application/json;charset=utf-8";
    String content_type_url = "Content-Type: application/x-www-form-urlencoded";
    String api_key = "X-API-KEY: your api key";


    @Headers({accept_json, content_type, api_key})
    @GET("jumlah_pegawai")
    Call<ResponseGetJumlahPegawai> getJumlahPegawai();

    @Headers({accept_json, content_type, api_key})
    @GET("jumlah_masuk")
    Call<ResponseGetJumlahMasuk> getJumlahMasuk();

    @Headers({accept_json, content_type, api_key})
    @GET("jumlah_belummasuk")
    Call<ResponseGetJumlahBelumMasuk> getBelumMasuk();

    @Headers({accept_json, content_type, api_key})
    @GET("nama")
    Call<ResponseGetAbsensiNama> getNama();

    //beda

    @Headers({accept_json, content_type, api_key})
    @GET("lokasi/user")
    Call<ResponseGetLokasi> getAllLokasi();

    @Headers({accept_json, content_type, api_key})
    @GET("lokasi/titil")
    Call<ResponseGetTitik> getTitik();

    @Headers({accept_json, content_type, api_key})
    @GET("user/user")
    Call<ResponseGetPegawai> getPegawai();

    @Headers({accept_json, content_type, api_key})
    @GET("laporan/laporan")
    Call<ResponseGetLaporan> getLaporan(@Query("id") String id);

    @Headers({accept_json, content_type, api_key})
    @POST("lokasi/location")
    Call<ResponseAction> updateLocation(@Body RequestPostUpdateLocation req);

    @Headers({accept_json, content_type, api_key})
    @POST("laporan/laporan")
    Call<ResponseAction> saveLaporan(@Body RequestPostLaporan req);

    @Headers({accept_json, content_type, api_key})
    @POST("user/auth")
    Call<ResponseAuthLogin> login(@Body RequestPostLogin req);

    @Headers({accept_json, content_type, api_key})
    @POST("user/register")
    Call<ResponseAction> register(@Body UserModel req);

    @Headers({accept_json, content_type, api_key})
    @POST("user/change_level")
    Call<ResponseAction> ubahlevel(@Body PegawaiModel req);

    @Headers({accept_json, content_type, api_key})
    @POST("user/change_password")
    Call<ResponseAction> ubahpassword(@Body RequestPostUpdatepassword req);

    @Headers({accept_json, content_type, api_key})
    @POST("user/change_profil")
    Call<ResponseAction> ubahprofil(@Body RequestPostUpdateProfil req);

    @Headers({accept_json, content_type, api_key})
    @POST("user/edit_user")
    Call<ResponseAction> ubahpegawai(@Body UserModel req);

    @Headers({accept_urlencoded, content_type_url, api_key})
    @FormUrlEncoded
    @POST("user/delete_user")
    Call<ResponseAction> hapuspegawai(@Field("id") String req);

    class Factory {
        public static ApiService create() {
            return ServiceFactory.createService(ApiService.class);
        }
    }

    class GatsuFactory {
        public static ApiService create() {
            return ServiceGatsuFactory.createService(ApiService.class);
        }
    }
}
