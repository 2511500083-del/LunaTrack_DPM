package com.example.lunatrack;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PesanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pesan);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);

        bottomNav.setSelectedItemId(R.id.nav_pesan);

        bottomNav.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_hari_ini) {
                startActivity(new Intent(PesanActivity.this, HomeActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_wawasan) {
                startActivity(new Intent(PesanActivity.this, WawasanActivity.class));
                finish();
                return true;
            }

            if (id == R.id.nav_pesan) {
                return true;
            }

            if (id == R.id.nav_profile) {
                startActivity(new Intent(PesanActivity.this, ProfileActivity.class));
                finish();
                return true;
            }

            return false;
        });

    }
}