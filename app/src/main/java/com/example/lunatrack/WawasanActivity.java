package com.example.lunatrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WawasanActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    TextView btnDetail1, btnDetail2, btnDetail3, btnLihatSemua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wawasan);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        btnDetail1 = findViewById(R.id.btnDetail1);
        btnDetail2 = findViewById(R.id.btnDetail2);
        btnDetail3 = findViewById(R.id.btnDetail3);
        btnLihatSemua = findViewById(R.id.btnLihatSemua);

        btnDetail1.setOnClickListener(v -> {

            Intent intent = new Intent(
                    WawasanActivity.this,
                    DetailArticle1Activity.class);

            startActivity(intent);

        });

        btnDetail2 = findViewById(R.id.btnDetail2);

        btnDetail2.setOnClickListener(v -> {

            Intent intent = new Intent(
                    WawasanActivity.this,
                    DetailArticle2Activity.class);

            startActivity(intent);

        });

/*
        btnDetail3.setOnClickListener(v -> {

            Intent intent = new Intent(
                    WawasanActivity.this,
                    DetailArticle3Activity.class);

            startActivity(intent);

        });
*/

/*
        btnLihatSemua.setOnClickListener(v -> {

            Intent intent = new Intent(
                    WawasanActivity.this,
                    SemuaArtikelActivity.class);

            startActivity(intent);

        });
*/

        // Menu Wawasan aktif
        bottomNavigation.setSelectedItemId(R.id.nav_wawasan);

        bottomNavigation.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_hari_ini) {

                startActivity(new Intent(WawasanActivity.this, HomeActivity.class));
                finish();
                return true;

            } else if (id == R.id.nav_wawasan) {

                return true;

            } else if (id == R.id.nav_pesan) {

                startActivity(new Intent(WawasanActivity.this, PesanActivity.class));
                finish();
                return true;

            } else if (id == R.id.nav_profile) {

                startActivity(new Intent(WawasanActivity.this, ProfileActivity.class));
                finish();
                return true;

            }

            return false;
        });

    }

}