package com.example.fadil.portaladmin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.modelapi.DataPengaduan;
import com.example.fadil.portaladmin.modelapi.ResponseAdministrasi;
import com.example.fadil.portaladmin.modelapi.ResponseOrganisasi;
import com.example.fadil.portaladmin.session.SessionManager;

import java.util.List;

public class ListOrganisasiAdapter extends RecyclerView.Adapter<ListOrganisasiAdapter.ListOrganisasiViewHolder> {
    private final List<DataPengaduan> listOrganisasi;
    //deklarasi global variabel
    private Context context;
    SessionManager session;

    //konstruktor untuk menerima data adapter
    public ListOrganisasiAdapter(Context context, List<DataPengaduan> listOrganisasi) {
        this.context = context;
        this.listOrganisasi = listOrganisasi;
    }
    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListOrganisasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pengaduan_organisasi, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListOrganisasiViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListOrganisasiViewHolder holder, int position) {
        final DataPengaduan mCurrent = listOrganisasi.get(position);
        //holder.tvNama.setText(mCurrent.getNama());
        session = new SessionManager(context);
        String nama = session.getNama();
        holder.tvNama.setText(nama);
        holder.tvNim.setText(mCurrent.getNim());
        holder.tvAdmin.setText(mCurrent.getJudul());
        holder.tvKeluhan.setText(mCurrent.getKeluhan());
        holder.tvSaran.setText(mCurrent.getSaran());
    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listOrganisasi.size();
    }
    public class ListOrganisasiViewHolder extends RecyclerView.ViewHolder{
        final ListOrganisasiAdapter mAdapter;
        private TextView tvNama, tvNim, tvAdmin, tvKeluhan, tvSaran;

        //untuk casting view yang digunakan pada list item
        public ListOrganisasiViewHolder(View itemView, ListOrganisasiAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            tvNama = itemView.findViewById(R.id.list_organisasi_nama);
            tvNim = itemView.findViewById(R.id.list_organisasi_nim);
            tvAdmin = itemView.findViewById(R.id.list_organisasi_organisasi);
            tvKeluhan = itemView.findViewById(R.id.list_organisasi_keluhan);
            tvSaran = itemView.findViewById(R.id.list_organisasi_saran);
            this.mAdapter = adapter;
        }
    }
}