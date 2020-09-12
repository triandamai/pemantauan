package com.kejaksaan.pemantauan.core.callback;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
public interface AdapterMenuClicked {
    void onEdit(int posisi);

    void onDelete(int posisi);

    void onDetail(int posisi);
}
