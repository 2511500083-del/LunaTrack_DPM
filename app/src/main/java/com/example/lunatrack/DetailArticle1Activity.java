package com.example.lunatrack;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DetailArticle1Activity extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article1);

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

    }
}