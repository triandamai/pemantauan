package com.kejaksaan.pemantauan.Pegawai.ui.tentang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TentangAplikasiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TentangAplikasiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is about fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}