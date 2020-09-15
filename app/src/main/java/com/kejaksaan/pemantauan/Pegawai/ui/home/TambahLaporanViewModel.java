package com.kejaksaan.pemantauan.Pegawai.ui.home;

import android.content.Context;
import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.tdn.data.persistensi.MyUser;
import com.tdn.data.service.ApiService;
import com.tdn.domain.serialize.req.RequestPostLaporan;
import com.tdn.domain.serialize.res.ResponseAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class TambahLaporanViewModel extends ViewModel {
    private ApiService apiService;
    private ActionListener actionListener;
    private Context context;

    public MutableLiveData<String> foto = new MutableLiveData<>();
    public MutableLiveData<String> lat = new MutableLiveData<>();
    public MutableLiveData<String> lng = new MutableLiveData<>();

    public TambahLaporanViewModel(Context context, ActionListener actionListener) {
        this.actionListener = actionListener;
        this.apiService = ApiService.Factory.create();
        this.context = context;
    }

    public void simpan(String desc) {
        actionListener.onStart();
        try {
            if (TextUtils.isEmpty(lat.getValue().toString()) && TextUtils.isEmpty(lng.getValue().toString()) && TextUtils.isEmpty(foto.getValue().toString()) && TextUtils.isEmpty(desc)) {
                actionListener.onError("Isi Semua Data!");

            } else {
                RequestPostLaporan lap = new RequestPostLaporan();
                lap.setDeskripsi(desc);
                lap.setIdLaporan("");
                lap.setIdPegawai(Integer.valueOf(MyUser.getInstance(context).getUser().getId()));
                lap.setMedia(foto.getValue());
                lap.setLat(lat.getValue());
                lap.setLng(lng.getValue());


                apiService.saveLaporan(lap).enqueue(new Callback<ResponseAction>() {
                    @Override
                    public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                        if (cek(response.code())) {
                            if (cek(response.body().getResponseCode())) {
                                actionListener.onSuccess(response.body().getResponseMessage());
                            } else {
                                actionListener.onError(response.body().getResponseMessage());
                            }
                        } else {
                            actionListener.onError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseAction> call, Throwable t) {
                        actionListener.onError(t.getMessage());
                    }
                });

            }
        } catch (Exception e) {
            actionListener.onError(e.getMessage());
        }
    }
}
