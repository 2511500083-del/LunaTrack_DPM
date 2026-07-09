package com.example.lunatrack;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PengingatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pengingat);

        // Mengatur padding agar tidak tertutup status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );
            return insets;
        });

        // Bottom Navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // Halaman Pengingat masih menggunakan menu Home
        // Jika nanti dibuat menu khusus Pengingat, tinggal diganti.
        bottomNav.setSelectedItemId(R.id.nav_hari_ini);

        bottomNav.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_hari_ini) {
                startActivity(new Intent(PengingatActivity.this, HomeActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_wawasan) {
                startActivity(new Intent(PengingatActivity.this, WawasanActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_pesan) {
                startActivity(new Intent(PengingatActivity.this, PesanActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_profile) {
                startActivity(new Intent(PengingatActivity.this, ProfileActivity.class));
                finish();
                return true;
            }

            return false;
        });

        // Tombol kembali
        findViewById(R.id.btnBack).setOnClickListener(v -> {
            finish();
        });

    }
}