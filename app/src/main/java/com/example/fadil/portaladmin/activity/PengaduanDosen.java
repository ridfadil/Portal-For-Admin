package com.example.fadil.portaladmin.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.adapter.ListAdminAdapter;
import com.example.fadil.portaladmin.adapter.ListDosenAdapter;
import com.example.fadil.portaladmin.adapter.ListOrganisasiAdapter;
import com.example.fadil.portaladmin.api.UtilsApi;
import com.example.fadil.portaladmin.modelapi.DataPengaduan;
import com.example.fadil.portaladmin.modelapi.ModelPengaduan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengaduanDosen extends AppCompatActivity {

    public List<DataPengaduan> responData = new ArrayList<>();
    FloatingActionButton fab;
    private List<ModelPengaduan> listDosen;
    private RecyclerView mRecyclerView;
    private ListDosenAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan_dosen);
        listDosen = new ArrayList<>();
        backButton();
 /*       SessionManager userPref = new SessionManager(getApplicationContext());
        final String accesToken = userPref.getAccesToken();*/

        Call<ModelPengaduan> call = UtilsApi.getAPIService().getAdministrasi();
        call.enqueue(new Callback<ModelPengaduan>() {
            @Override
            public void onResponse(Call<ModelPengaduan> call, Response<ModelPengaduan> response) {
                //Toast.makeText(ListPresensiActivity.this, "harusnya bener", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    responData = response.body().getData();
                    mRecyclerView.setAdapter(new ListDosenAdapter(getApplicationContext(), responData));
                    mAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(PengaduanDosen.this, "not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelPengaduan> call, Throwable t) {
                Toast.makeText(PengaduanDosen.this, "Error", Toast.LENGTH_SHORT).show();
            }

        });


        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_dosen);

        mAdapter = new ListDosenAdapter(getApplicationContext(), responData);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //untuk enampilkan back button
    public void backButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pengaduan Dosen");
    }

    //fungsi back ketika tombol back diklik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
