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
import com.example.fadil.portaladmin.modelapi.ResponseAdministrasi;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAdminAdapter extends RecyclerView.Adapter<ListAdminAdapter.ListAdminViewHolder> {
    private final List<ResponseAdministrasi> listAdmin;
    //deklarasi global variabel
    private Context context;


    //konstruktor untuk menerima data adapter
    public ListAdminAdapter(Context context, List<ResponseAdministrasi> listAdmin) {
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
       final ResponseAdministrasi mCurrent = listAdmin.get(position);
       /*
        holder.tvNamaUser.setText(mCurrent.getNama());
        holder.tvTanggal.setText(mCurrent.getCreatedAt());
        holder.tvBacklog.setText(mCurrent.getBacklog());
        holder.tvTask.setText(mCurrent.getTask());
        holder.tvNote.setText(mCurrent.getNote());*/
       holder.tvNama.setText(mCurrent.getNama());
       holder.tvNim.setText(mCurrent.getNim());
       holder.tvAdmin.setText(mCurrent.getAdmin());
       holder.tvKeluhan.setText(mCurrent.getKeluhan());
       holder.tvSaran.setText(mCurrent.getSaran());
    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listAdmin.size();
    }

    public class ListAdminViewHolder extends RecyclerView.ViewHolder/* implements View.OnLongClickListener */ {
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
           /* tvNamaUser = (TextView) itemView.findViewById(R.id.tv_nama_karyawan_presensi);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_status);
            tvTanggal = (TextView) itemView.findViewById(R.id.tv_tanggal);
            tvBacklog = (TextView) itemView.findViewById(R.id.tv_backlog);
            tvTask = (TextView) itemView.findViewById(R.id.tv_task);
            tvNote = (TextView) itemView.findViewById(R.id.tv_note);*/
            this.mAdapter = adapter;
        }
    }
}