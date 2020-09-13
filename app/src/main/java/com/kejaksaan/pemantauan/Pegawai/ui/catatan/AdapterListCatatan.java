package com.kejaksaan.pemantauan.Pegawai.ui.catatan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.ui.home.DetailLaporanActivity;
import com.kejaksaan.pemantauan.core.callback.AdapterClicked;
import com.kejaksaan.pemantauan.core.callback.AdapterMenuClicked;
import com.kejaksaan.pemantauan.databinding.ItemCatatanBinding;
import com.kejaksaan.pemantauan.databinding.ItemLaporanBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.CatatanModel;
import com.tdn.domain.model.LaporanModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterListCatatan extends RecyclerView.Adapter<AdapterListCatatan.MyViewHolder> {
    private List<CatatanModel> data = new ArrayList<>();
    private Context context;
    private AdapterMenuClicked adapterClicked;

    public AdapterListCatatan(AdapterMenuClicked adapterClicked) {
        this.adapterClicked = adapterClicked;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCatatanBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_catatan, parent, false);
        context = parent.getContext();
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvNama.setText(data.get(position).getNamaLengkap());
        holder.binding.tvNrp.setText("NRP : " + data.get(position).getNrp() + "\nKet : " + data.get(position).getJudul() + "\nKODE : " + data.get(position).getIsi());
        holder.binding.tvLevel.setText(data.get(position).getTanggal());
        holder.binding.textViewOptions.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.binding.textViewOptions);
            popupMenu.inflate(R.menu.menu_item_pegawai);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.edit:
                        adapterClicked.onEdit(position);
                        break;
                    case R.id.hapus:
                        adapterClicked.onDelete(position);
                        break;
                }
                return false;
            });
            popupMenu.show();
        });
        MyUser.getInstance(context).setLastCatatan(data.get(position));
        context.startActivity(new Intent(context, DetailLaporanActivity.class));

    }

    public void setdata(List<CatatanModel> namaList) {
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
        private ItemCatatanBinding binding;

        public MyViewHolder(@NonNull ItemCatatanBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
