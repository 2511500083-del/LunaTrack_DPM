package com.example.lunatrack;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PengingatActivity extends AppCompatActivity {

    EditText etJudul, etDeskripsi, etTanggal, etWaktu;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengingat);

        etTanggal.setOnClickListener(v -> pilihTanggal());
        etWaktu.setOnClickListener(v -> pilihWaktu());

        btnSimpan.setOnClickListener(v -> {

            String judul = etJudul.getText().toString();
            String deskripsi = etDeskripsi.getText().toString();

            if(judul.isEmpty()){
                etJudul.setError("Judul wajib diisi");
                return;
            }

            Toast.makeText(this,
                    "Pengingat berhasil disimpan",
                    Toast.LENGTH_SHORT).show();
        });
    }

    private void pilihTanggal() {

        Calendar calendar = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) ->
                        etTanggal.setText(dayOfMonth + "/" + (month+1) + "/" + year),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        dialog.show();
    }

    private void pilihWaktu() {

        Calendar calendar = Calendar.getInstance();

        TimePickerDialog dialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minute) ->
                        etWaktu.setText(hourOfDay + ":" + minute),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        );

        dialog.show();
    }
}