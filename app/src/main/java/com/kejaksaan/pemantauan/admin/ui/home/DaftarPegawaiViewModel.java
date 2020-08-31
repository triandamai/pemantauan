package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tdn.data.service.ApiService;
import com.tdn.domain.model.UserModel;

import java.util.List;

public class DaftarPegawaiViewModel extends ViewModel {
    private ApiService apiService;

    public DaftarPegawaiViewModel() {
        this.apiService = ApiService.Factory.create();
        getPegawai();
    }

    private LiveData<List<UserModel>> getPegawai() {
        final MutableLiveData<List<UserModel>> data = new MutableLiveData<>();
        apiService.
        return data;
    }
}
