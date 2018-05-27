package com.example.fadil.portaladmin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.modelapi.DataPengaduan;

import java.util.List;

public class ListDosenAdapter extends RecyclerView.Adapter<ListDosenAdapter.ListDosenViewHolder> {
    private final List<DataPengaduan> listDosen;
    //deklarasi global variabel
    private Context context;

    //konstruktor untuk menerima data adapter
    public ListDosenAdapter(Context context, List<DataPengaduan> listDosen) {
        this.context = context;
        this.listDosen = listDosen;
    }
    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListDosenAdapter.ListDosenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pengaduan_dosen, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListDosenViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListDosenViewHolder holder, int position) {
        final DataPengaduan mCurrent = listDosen.get(position);
        holder.tvNama.setText("Pengaduan Dosen");
        holder.tvNim.setText(mCurrent.getNim());
        holder.tvAdmin.setText(mCurrent.getJudul());
        holder.tvKeluhan.setText(mCurrent.getKeluhan());
        holder.tvSaran.setText(mCurrent.getSaran());
    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listDosen.size();
    }
    public class ListDosenViewHolder extends RecyclerView.ViewHolder{
        final ListDosenAdapter mAdapter;
        private TextView tvNama, tvNim, tvAdmin, tvKeluhan, tvSaran;

        //untuk casting view yang digunakan pada list item
        public ListDosenViewHolder(View itemView, ListDosenAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            tvNama = itemView.findViewById(R.id.list_Dosen_nama);
            tvNim = itemView.findViewById(R.id.list_dosen_nim);
            tvAdmin = itemView.findViewById(R.id.list_dosen_judul);
            tvKeluhan = itemView.findViewById(R.id.list_dosen_keluhan);
            tvSaran = itemView.findViewById(R.id.list_dosen_saran);
            this.mAdapter = adapter;
        }
    }
}