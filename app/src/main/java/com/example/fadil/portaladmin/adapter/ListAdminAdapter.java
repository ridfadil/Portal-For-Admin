package com.example.fadil.portaladmin.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.modelapi.DataPengaduan;
import com.example.fadil.portaladmin.modelapi.ResponseAdministrasi;
import com.example.fadil.portaladmin.session.SessionManager;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAdminAdapter extends RecyclerView.Adapter<ListAdminAdapter.ListAdminViewHolder> {
    private final List<DataPengaduan> listAdmin;
    //deklarasi global variabel
    private Context context;
    SessionManager session;


    //konstruktor untuk menerima data adapter
    public ListAdminAdapter(Context context, List<DataPengaduan> listAdmin) {
        this.context = context;
        this.listAdmin = listAdmin;
    }

    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListAdminViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pengaduan_admin, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListAdminViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListAdminViewHolder holder, int position) {
       final DataPengaduan mCurrent = listAdmin.get(position);
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
        return listAdmin.size();
    }

    public class ListAdminViewHolder extends RecyclerView.ViewHolder{
        final ListAdminAdapter mAdapter;
        private TextView tvNama, tvNim, tvAdmin, tvKeluhan, tvSaran;

        //untuk casting view yang digunakan pada list item
        public ListAdminViewHolder(View itemView, ListAdminAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            tvNama = itemView.findViewById(R.id.list_admin_nama);
            tvNim = itemView.findViewById(R.id.list_admin_nim);
            tvAdmin = itemView.findViewById(R.id.list_admin_administrasi);
            tvKeluhan = itemView.findViewById(R.id.list_admin_keluhan);
            tvSaran = itemView.findViewById(R.id.list_admin_saran);
            this.mAdapter = adapter;
        }
    }
}