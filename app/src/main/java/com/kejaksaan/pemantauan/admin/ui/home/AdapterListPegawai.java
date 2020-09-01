package com.kejaksaan.pemantauan.admin.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ItemListPresensiBinding;
import com.kejaksaan.pemantauan.databinding.ItemPegawaiBinding;
import com.tdn.domain.model.AbsensiNama;
import com.tdn.domain.model.PegawaiModel;
import com.tdn.domain.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterListPegawai extends RecyclerView.Adapter<AdapterListPegawai.MyViewHolder> {
    private List<PegawaiModel> data = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPegawaiBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_pegawai, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvNama.setText("" + data.get(position).getNamaLengkap());
        holder.binding.tvNrp.setText("NRP : " + data.get(position).getNrp());
        holder.binding.tvLevel.setText("Sebagai : " + data.get(position).getLevel());
    }

    public void setdata(List<PegawaiModel> namaList) {
        if (this.data == null) {
            this.data = namaList;
        } else {
            this.data.addAll(namaList);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemPegawaiBinding binding;

        public MyViewHolder(@NonNull ItemPegawaiBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
