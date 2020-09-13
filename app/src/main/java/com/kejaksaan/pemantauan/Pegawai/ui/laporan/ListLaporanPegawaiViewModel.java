package com.kejaksaan.pemantauan.Pegawai.ui.laporan;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tdn.data.persistensi.MyUser;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.LaporanModel;
import com.tdn.domain.serialize.res.ResponseGetLaporan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class ListLaporanPegawaiViewModel extends ViewModel {
    private ApiService apiService;
    private Context context;

    public ListLaporanPegawaiViewModel(Context context) {
        this.apiService = ApiService.Factory.create();
        this.context = context;
        getLaporan();
    }

    public LiveData<List<LaporanModel>> getLaporan() {

        final MutableLiveData<List<LaporanModel>> data = new MutableLiveData<>();
        apiService.getLaporan(MyUser.getInstance(context).getUser().getId()).enqueue(new Callback<ResponseGetLaporan>() {
            @Override
            public void onResponse(Call<ResponseGetLaporan> call, Response<ResponseGetLaporan> response) {
                Log.e("re", "hadehh" + response.body().toString());
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            List<LaporanModel> list = response.body().getData();
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
            public void onFailure(Call<ResponseGetLaporan> call, Throwable t) {
                data.setValue(null);
                Log.e("re", "hadeeh" + t.getMessage());
            }
        });
        return data;
    }
}
