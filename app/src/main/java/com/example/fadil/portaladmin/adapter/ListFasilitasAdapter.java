package com.example.fadil.portaladmin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.modelapi.DataPengaduan;
import com.example.fadil.portaladmin.session.SessionManager;

import java.util.List;

public class ListFasilitasAdapter extends RecyclerView.Adapter<ListFasilitasAdapter.ListFasilitasViewHolder> {
    private final List<DataPengaduan> listFasilitas;
    //deklarasi global variabel
    private Context context;
    SessionManager session;


    //konstruktor untuk menerima data adapter
    public ListFasilitasAdapter(Context context, List<DataPengaduan> listFasilitas) {
        this.context = context;
        this.listFasilitas= listFasilitas;
    }

    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListFasilitasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pengaduan_fasilitas, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListFasilitasViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListFasilitasViewHolder holder, int position) {
        final DataPengaduan mCurrent = listFasilitas.get(position);
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
        return listFasilitas.size();
    }

    public class ListFasilitasViewHolder extends RecyclerView.ViewHolder{
        final ListFasilitasAdapter mAdapter;
        private TextView tvNama, tvNim, tvAdmin, tvKeluhan, tvSaran;

        //untuk casting view yang digunakan pada list item
        public ListFasilitasViewHolder(View itemView, ListFasilitasAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            tvNama = itemView.findViewById(R.id.list_fasilitas_nama);
            tvNim = itemView.findViewById(R.id.list_fasilitas_nim);
            tvAdmin = itemView.findViewById(R.id.list_dosen_judul);
            tvKeluhan = itemView.findViewById(R.id.list_fasilitas_keluhan);
            tvSaran = itemView.findViewById(R.id.list_admin_saran);
            this.mAdapter = adapter;
        }
    }
}