package com.example.fadil.portaladmin.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.adapter.SlidingAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity {

    private static final Integer[] IMAGES = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    CardView cdFasilitas, cdDosen, cdAdministrasi, cdOrganisasi, cdStatistik, cdTentang;
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initSlider();
        initialized();
        actionClicked();
    }

    public void actionClicked() {
        cdFasilitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, PengaduanFasilitas.class);
                startActivity(i);
            }
        });

        cdDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, PengaduanDosen.class);
                startActivity(i);
            }
        });

        cdStatistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, PengaduanStatistik.class);
                startActivity(i);
            }
        });

        cdAdministrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, PengaduanAdministrasi.class);
                startActivity(i);
            }
        });

        cdOrganisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, PengaduanOrganisasi.class);
                startActivity(i);
            }
        });

        cdTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, Tentang.class);
                startActivity(i);
            }
        });
    }

    public void initialized() {
        cdFasilitas = findViewById(R.id.cv_fasilitas);
        cdDosen = findViewById(R.id.cv_dosen);
        cdAdministrasi = findViewById(R.id.cv_Administrasi);
        cdOrganisasi = findViewById(R.id.cv_organisasi);
        cdStatistik = findViewById(R.id.cv_statistik);
        cdTentang = findViewById(R.id.cv_tentang);
    }

    private void initSlider() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingAdapter(com.example.fadil.portaladmin.activity.DashboardActivity.this, ImagesArray));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
}
