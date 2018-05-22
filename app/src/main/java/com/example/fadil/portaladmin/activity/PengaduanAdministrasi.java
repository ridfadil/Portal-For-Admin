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
import com.example.fadil.portaladmin.modelapi.ResponseAdministrasi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengaduanAdministrasi extends AppCompatActivity {

    private List<ResponseAdministrasi> listAdmin;
    private RecyclerView mRecyclerView;
    private ListAdminAdapter mAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan_administrasi);
        listAdmin = new ArrayList<>();
        backButton();
 /*       SessionManager userPref = new SessionManager(getApplicationContext());
        final String accesToken = userPref.getAccesToken();*/

        /*Call<List<Present>> call = UtilsApi.getAPIService().getAllPresent("Bearer "+accesToken);
        call.enqueue(new Callback<List<Present>>() {
            @Override
            public void onResponse(Call<List<Present>> call, Response<List<Present>> response) {
                Toast.makeText(ListPresensiActivity.this, "harusnya bener", Toast.LENGTH_SHORT).show();
                if (response.code()==200){
                    List<Present> allUser = response.body();
                    for(int i = 0; i<allUser.size(); i++){
                        String id = allUser.get(i).getId();
                        String email = allUser.get(i).getEmail();
                        String nama = allUser.get(i).getNama();
                        String statusPrs = allUser.get(i).getStatusPrs();
                        String backlog = allUser.get(i).getBacklog();
                        String task = allUser.get(i).getTask();
                        String note = allUser.get(i).getNote();
                        String createdAt = allUser.get(i).getCreatedAt();
                        String updatedAt = allUser.get(i).getUpdatedAt();
                        int v = allUser.get(i).getV();*/
                        String nama = "Muhamad Farid Padilah ";
                        String nim = "1157050094";
                        String admin = "Himatif";
                        String keluhan = "Lorem ipsum Doekler fgj huyy ghg j kjjkju dfcfgf iy";
                        String saran = "Lorem ipsum Doekler fgj huyy ghg j kjjkju dfcfgf iy ytuyut tyujtyu tyutjyu tyutyuty tyutydfgd";
                        listAdmin.add(new ResponseAdministrasi(nama,nim,admin,keluhan,saran));
                   /* }
                }
                else {
                    Toast.makeText(ListPresensiActivity.this, "not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Present>> call, Throwable t) {
                Toast.makeText(ListPresensiActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });*/


        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_admin);

        mAdapter = new ListAdminAdapter(getApplicationContext(), listAdmin);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //untuk enampilkan back button
    public void backButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pengaduan Administrasi");
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
