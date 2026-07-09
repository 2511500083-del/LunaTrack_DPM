package com.example.lunatrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nama Database
    public static final String DATABASE_NAME = "LunaTrack.db";

    // Versi Database
    public static final int DATABASE_VERSION = 1;

    // Nama Tabel
    public static final String TABLE_USER = "users";

    // Kolom
    public static final String COL_ID = "id";
    public static final String COL_NAMA = "nama";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Membuat tabel
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_USER + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAMA + " TEXT, "
                + COL_EMAIL + " TEXT UNIQUE, "
                + COL_PASSWORD + " TEXT)";

        db.execSQL(query);
    }

    // Jika versi database berubah
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);

    }

    // ==========================
    // REGISTER
    // ==========================

    public boolean insertUser(String nama, String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_NAMA, nama);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);

        long result = db.insert(TABLE_USER, null, values);

        return result != -1;
    }

    // ==========================
    // LOGIN
    // ==========================

    public boolean checkLogin(String email, String password) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_USER +
                        " WHERE email=? AND password=?",
                new String[]{email, password});

        boolean login = cursor.getCount() > 0;

        cursor.close();

        return login;
    }

    // ==========================
    // CEK EMAIL SUDAH ADA
    // ==========================

    public boolean checkEmail(String email) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_USER +
                        " WHERE email=?",
                new String[]{email});

        boolean ada = cursor.getCount() > 0;

        cursor.close();

        return ada;
    }

}