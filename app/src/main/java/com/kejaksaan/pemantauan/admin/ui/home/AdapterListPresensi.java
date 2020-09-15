package com.kejaksaan.pemantauan.admin.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ItemListPresensiBinding;
import com.tdn.domain.model.AbsensiNama;

import java.util.ArrayList;
import java.util.List;

public class AdapterListPresensi extends RecyclerView.Adapter<AdapterListPresensi.MyViewHolder> {
    private List<AbsensiNama> data = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListPresensiBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list_presensi, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvNama.setText(data.get(position).getKaryawanNamaFull());
    }

    public void setdata(List<AbsensiNama> namaList) {
        if (this.data == null) {
            this.data = namaList;
        } else {
            this.data.clear();
            this.data.addAll(namaList);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemListPresensiBinding binding;

        public MyViewHolder(@NonNull ItemListPresensiBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
