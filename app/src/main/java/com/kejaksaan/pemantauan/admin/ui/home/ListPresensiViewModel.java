package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tdn.data.service.ApiService;
import com.tdn.domain.model.AbsensiNama;
import com.tdn.domain.model.JumlahMasukModel;
import com.tdn.domain.model.JumlahPegawaiModel;
import com.tdn.domain.serialize.res.ResponseGetAbsensiNama;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class ListPresensiViewModel extends ViewModel {

    private ApiService apiService;

    public ListPresensiViewModel() {
        this.apiService = ApiService.GatsuFactory.create();
        getPresensi();
    }

    private LiveData<List<AbsensiNama>> getPresensi() {
        final MutableLiveData<List<AbsensiNama>> data = new MutableLiveData<>();
        apiService.getNama().enqueue(new Callback<ResponseGetAbsensiNama>() {
            @Override
            public void onResponse(Call<ResponseGetAbsensiNama> call, Response<ResponseGetAbsensiNama> response) {
                if (cek(response.code())) {
                    if (response.body().getNama() != null) {
                        if (response.body().getNama().size() > 0) {
                            List<AbsensiNama> list = response.body().getNama();
                            data.setValue(list);
                        } else {
                            data.setValue(null);
                        }
                    } else {
                        data.setValue(null);
                    }
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetAbsensiNama> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
