package com.example.lunatrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PesanActivity extends AppCompatActivity {

    private ImageView btnSearch;
    private ImageView btnTambah;

    private ImageView navHome;
    private ImageView navInsight;
    private ImageView navChat;
    private ImageView navProfile;

    private Button btnHamil;
    private Button btnTelat;
    private Button btnSubur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        // Header
        btnSearch = findViewById(R.id.btnSearch);
        btnTambah = findViewById(R.id.btnTambah);

        // Bottom Navigation
        navHome = findViewById(R.id.navHome);
        navInsight = findViewById(R.id.navInsight);
        navChat = findViewById(R.id.navChat);
        navProfile = findViewById(R.id.navProfile);

        // Tombol Pertanyaan
        btnHamil = findViewById(R.id.btnHamil);
        btnTelat = findViewById(R.id.btnTelat);
        btnSubur = findViewById(R.id.btnSubur);

        // ==========================
        // Tombol Pertanyaan
        // ==========================

        btnHamil.setOnClickListener(v -> {
            Intent intent = new Intent(PesanActivity.this, ChatActivity.class);
            intent.putExtra("pertanyaan", "Apakah saya hamil?");
            startActivity(intent);
        });

        btnTelat.setOnClickListener(v -> {
            Intent intent = new Intent(PesanActivity.this, ChatActivity.class);
            intent.putExtra("pertanyaan", "Kenapa telat haid?");
            startActivity(intent);
        });

        btnSubur.setOnClickListener(v -> {
            Intent intent = new Intent(PesanActivity.this, ChatActivity.class);
            intent.putExtra("pertanyaan", "Kapan masa subur saya?");
            startActivity(intent);
        });

        // ==========================
        // Header
        // ==========================

        btnSearch.setOnClickListener(v -> {

            // Nanti bisa diarahkan ke halaman pencarian

        });

        btnTambah.setOnClickListener(v -> {

            // Nanti bisa diarahkan ke halaman tambah chat

        });

        // ==========================
        // Bottom Navigation
        // ==========================

        navHome.setOnClickListener(v -> {
            startActivity(new Intent(PesanActivity.this, HomeActivity.class));
            finish();
        });

        navInsight.setOnClickListener(v -> {
            startActivity(new Intent(PesanActivity.this, WawasanActivity.class));
            finish();
        });

        navProfile.setOnClickListener(v -> {
            startActivity(new Intent(PesanActivity.this, ProfilActivity.class));
            finish();
        });

    }

}