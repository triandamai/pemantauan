package com.kejaksaan.pemantauan.Pegawai.ui.catatan;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.tdn.data.persistensi.MyUser;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.CatatanModel;
import com.tdn.domain.model.LaporanModel;
import com.tdn.domain.serialize.req.RequestPostDeleteCatatan;
import com.tdn.domain.serialize.res.ResponseAction;
import com.tdn.domain.serialize.res.ResponseGetCatatan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class ListCatatanViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private ApiService apiService;
    private Context context;
    private ActionListener actionListener;

    public ListCatatanViewModel(Context context, ActionListener actionListener) {
        this.apiService = ApiService.Factory.create();
        this.context = context;
        this.actionListener = actionListener;
        getCatatan();
    }

    public LiveData<List<CatatanModel>> getCatatan() {
        final MutableLiveData<List<CatatanModel>> data = new MutableLiveData<>();
        apiService.getCatatan(MyUser.getInstance(context).getUser().getId())
                .enqueue(new Callback<ResponseGetCatatan>() {
                    @Override
                    public void onResponse(Call<ResponseGetCatatan> call, Response<ResponseGetCatatan> response) {
                        if (cek(response.code())) {
                            if (cek(response.body().getResponseCode())) {
                                if (response.body().getData() != null) {
                                    List<CatatanModel> list = response.body().getData();
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
                    public void onFailure(Call<ResponseGetCatatan> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public void hapus(CatatanModel catatanModel) {
        actionListener.onStart();
        RequestPostDeleteCatatan req = new RequestPostDeleteCatatan();
        req.setId(catatanModel.getIdCatatan());
        Log.e("hehe1", req.toString());

        apiService.deletecatatan(req)
                .enqueue(new Callback<ResponseAction>() {
                    @Override
                    public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                        if (cek(response.code())) {
                            Log.e("hehe", response.body().toString());
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
}