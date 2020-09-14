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
        holder.binding.tvJudul.setText(data.get(position).getJudul());
        holder.binding.tvOwner.setText(data.get(position).getNamaLengkap() + " - " + data.get(position).getNrp());
        holder.binding.tvIsi.setText(data.get(position).getIsi());
        holder.binding.tvTanggal.setText(data.get(position).getTanggal());
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

        // context.startActivity(new Intent(context, DetailLaporanActivity.class));

    }

    public void setdata(List<CatatanModel> namaList) {
        if (this.data == null) {
            this.data = namaList;
        } else {
            this.data.clear();
            this.data.addAll(namaList);
        }
        notifyDataSetChanged();
    }

    public CatatanModel getFromPos(int pos) {
        return data.get(pos);
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
