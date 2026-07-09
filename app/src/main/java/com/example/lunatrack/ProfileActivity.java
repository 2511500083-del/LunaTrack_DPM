package com.example.lunatrack;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

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
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);

        // Menu Profil dipilih
        bottomNav.setSelectedItemId(R.id.nav_profile);

        bottomNav.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_hari_ini) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_wawasan) {
                startActivity(new Intent(ProfileActivity.this, WawasanActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_pesan) {
                startActivity(new Intent(ProfileActivity.this, PesanActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_profile) {
                return true;
            }

            return false;
        });

    }
}