package com.example.lunatrack;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etNama, etEmail, etPassword, etKonfirmasiPassword;
    Button btnDaftar;
    TextView txtLogin;
    ImageView ivShowPassword;

    boolean isPasswordVisible = false;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi Database
        db = new DatabaseHelper(this);

        // Inisialisasi Komponen
        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etKonfirmasiPassword = findViewById(R.id.etKonfirmasiPassword);

        btnDaftar = findViewById(R.id.btnDaftar);
        txtLogin = findViewById(R.id.txtLogin);
        ivShowPassword = findViewById(R.id.imgShowPassword);

        // Show / Hide Password
        ivShowPassword.setOnClickListener(v -> {

            if (isPasswordVisible) {

                etPassword.setInputType(
                        InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD
                );

                isPasswordVisible = false;

            } else {

                etPassword.setInputType(
                        InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                );

                isPasswordVisible = true;
            }

            etPassword.setSelection(etPassword.getText().length());

        });

        // Tombol Daftar
        btnDaftar.setOnClickListener(v -> {

            String nama = etNama.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String konfirmasi = etKonfirmasiPassword.getText().toString().trim();

            // Validasi kosong
            if (nama.isEmpty() ||
                    email.isEmpty() ||
                    password.isEmpty() ||
                    konfirmasi.isEmpty()) {

                Toast.makeText(RegisterActivity.this,
                        "Lengkapi semua data",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            // Password tidak sama
            if (!password.equals(konfirmasi)) {

                Toast.makeText(RegisterActivity.this,
                        "Password tidak cocok",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            // Email sudah digunakan
            if (db.checkEmail(email)) {

                Toast.makeText(RegisterActivity.this,
                        "Email sudah terdaftar",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            // Simpan ke SQLite
            boolean insert = db.insertUser(nama, email, password);

            if (insert) {

                Toast.makeText(RegisterActivity.this,
                        "Registrasi Berhasil",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(
                        RegisterActivity.this,
                        LoginActivity.class);

                startActivity(intent);
                finish();

            } else {

                Toast.makeText(RegisterActivity.this,
                        "Registrasi Gagal",
                        Toast.LENGTH_SHORT).show();

            }

        });

        // Pindah ke Login
        txtLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RegisterActivity.this,
                    LoginActivity.class);

            startActivity(intent);

            finish();

        });

    }
}