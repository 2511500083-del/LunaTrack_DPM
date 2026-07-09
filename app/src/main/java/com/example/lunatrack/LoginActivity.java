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

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnMasuk;
    TextView txtRegister;
    ImageView ivShowPassword;

    boolean isPasswordVisible = false;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi Database
        db = new DatabaseHelper(this);

        // Inisialisasi Komponen
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnMasuk = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);
        ivShowPassword = findViewById(R.id.btnEye);

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

        // Pindah ke Register
        txtRegister.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    RegisterActivity.class
            );

            startActivity(intent);

        });

        // Tombol Login
        btnMasuk.setOnClickListener(v -> {

            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Validasi Email
            if (email.isEmpty()) {

                etEmail.setError("Email tidak boleh kosong");
                etEmail.requestFocus();
                return;

            }

            // Validasi Password
            if (password.isEmpty()) {

                etPassword.setError("Password tidak boleh kosong");
                etPassword.requestFocus();
                return;

            }

            // Cek Login ke SQLite
            boolean login = db.checkLogin(email, password);

            if (login) {

                Toast.makeText(
                        LoginActivity.this,
                        "Login Berhasil",
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        HomeActivity.class
                );

                startActivity(intent);
                finish();

            } else {

                Toast.makeText(
                        LoginActivity.this,
                        "Email atau Password salah",
                        Toast.LENGTH_SHORT
                ).show();

            }

        });

    }

}