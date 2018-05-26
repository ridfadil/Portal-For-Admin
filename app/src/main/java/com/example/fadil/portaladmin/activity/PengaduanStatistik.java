package com.example.fadil.portaladmin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.adapter.ListAdminAdapter;
import com.example.fadil.portaladmin.api.UtilsApi;
import com.example.fadil.portaladmin.modelapi.DataPengaduan;
import com.example.fadil.portaladmin.modelapi.ModelPengaduan;
import com.example.fadil.portaladmin.modelapi.ResponseStatistik;
import com.example.fadil.portaladmin.modelapi.Statistik;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengaduanStatistik extends AppCompatActivity {

    List<Statistik> responData =new ArrayList<>();
    @BindView(R.id.tv_stat_jum_fasilitas)
    TextView tvStatJumFasilitas;
    @BindView(R.id.tv_stat_jum_admin)
    TextView tvStatJumAdmin;
    @BindView(R.id.tv_stat_jum_organisasi)
    TextView tvStatJumOrganisasi;
    @BindView(R.id.tv_stat_jum_Dosen)
    TextView tvStatJumDosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan_statistik);
        ButterKnife.bind(this);
        getStatistika();
        backButton();
    }

    public void getStatistika(){
        Call<ResponseStatistik> call = UtilsApi.getAPIService().getStatistik();
        call.enqueue(new Callback<ResponseStatistik>() {
            @Override
            public void onResponse(Call<ResponseStatistik> call, Response<ResponseStatistik> response) {
                // Toast.makeText(PengaduanAdministrasi.this, "harusnya bener", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    responData = response.body().getStatistik();
                    String administrasi = responData.get(0).getAdministrasi();
                    String fasilitas = responData.get(0).getFasilitas();
                    String dosen = responData.get(0).getDosen();
                    String organisasi = responData.get(0).getOrganisasi();

                    tvStatJumAdmin.setText(administrasi);
                    tvStatJumDosen.setText(dosen);
                    tvStatJumFasilitas.setText(fasilitas);
                    tvStatJumOrganisasi.setText(organisasi);

                } else {
                    Toast.makeText(PengaduanStatistik.this, "not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseStatistik> call, Throwable t) {
                Toast.makeText(PengaduanStatistik.this, "Error", Toast.LENGTH_SHORT).show();
            }

        });
    }


    //untuk enampilkan back button
    public void backButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Data Statistik");
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
