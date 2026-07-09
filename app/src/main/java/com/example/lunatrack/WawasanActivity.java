package com.example.lunatrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WawasanActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    TextView btnDetail1, btnDetail2, btnDetail3, btnLihatSemua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wawasan);

        bottomNav = findViewById(R.id.bottomNav);
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
        bottomNav.setSelectedItemId(R.id.nav_wawasan);

        bottomNav.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_hari_ini) {

                startActivity(new Intent(WawasanActivity.this, HomeActivity.class));
                finish();
                return true;

            } else if (id == R.id.nav_wawasan) {

                return true;

            } else if (id == R.id.nav_pesan) {

                // TODO: Buka PesanActivity
                return true;

            } else if (id == R.id.nav_profile) {

                // TODO: Buka ProfileActivity
                return true;

            }

            return false;
        });

    }

}