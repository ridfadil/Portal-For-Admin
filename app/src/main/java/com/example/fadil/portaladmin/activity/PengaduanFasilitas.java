package com.example.fadil.portaladmin.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fadil.portaladmin.R;

public class PengaduanFasilitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan_fasilitas);
        backButton();
    }

    //untuk enampilkan back button
    public void backButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pengaduan Fasilitas");
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