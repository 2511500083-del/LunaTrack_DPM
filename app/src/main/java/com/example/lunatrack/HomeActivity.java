package com.example.lunatrack;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

            bottomNav.setSelectedItemId(R.id.nav_home);

            bottomNav.setOnItemSelectedListener(item -> {

                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    return true;
                }

                if (id == R.id.nav_wawasan) {
                    startActivity(new Intent(this, WawasanActivity.class));
                    return true;
                }

                if (id == R.id.nav_pesan) {
                    startActivity(new Intent(this, PesanActivity.class));
                    return true;
                }

                if (id == R.id.nav_profil) {
                    startActivity(new Intent(this, ProfilActivity.class));
                    return true;
                }

                return false;
            });
        });
    }
}