package com.kejaksaan.pemantauan.admin.ui.pantau;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tdn.data.local.RealmLiveResult;
import com.tdn.data.repository.Repository;
import com.tdn.domain.model.TitikModel;
import com.tdn.domain.object.LokasiObject;
import com.tdn.domain.object.TitikObject;

import java.util.List;

import io.realm.Realm;

public class PantauViewModel extends ViewModel {
    private Realm realm;
    private LiveData<List<LokasiObject>> listLiveData;
    private LiveData<List<TitikObject>> listtitikData;

    public PantauViewModel() {
        this.realm = Realm.getDefaultInstance();
        getFromApi();
        getFromLocal();
    }

    public void getFromApi() {
        Repository.getInstance().getAllLokasi();
    }

    public void getFromLocal() {
        this.listLiveData = new RealmLiveResult(realm.where(LokasiObject.class).findAll());
    }

    public LiveData<List<LokasiObject>> getListLiveData() {
        if (listLiveData == null) {
            listLiveData = new MutableLiveData<>();
        }
        return listLiveData;
    }

}
