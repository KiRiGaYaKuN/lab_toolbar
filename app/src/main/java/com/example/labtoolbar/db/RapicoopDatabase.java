package com.example.labtoolbar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class RapicoopDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Rapicoop.db";
    public static final int DATABASE_VERSION=17;
    public static final String TABLE_NAME="t_usuarios";
    public static final String TABLE_OFERTA="t_ofertas";
    public static final String TABLE_CARRITO="t_carrito";


    public RapicoopDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,usuario TEXT,"
                + "nombres TEXT,apellidos TEXT,correo TEXT,telefono TEXT,password TEXT,rol TEXT)");

        db.execSQL("create table " + TABLE_OFERTA + "(id INTEGER PRIMARY KEY AUTOINCREMENT,usuario TEXT,"
                + "nombre TEXT,categoria TEXT,precio INTEGER,ubicacion TEXT,descripcion TEXT,imagen BLOB)");

        db.execSQL("create table " + TABLE_CARRITO + "(id INTEGER PRIMARY KEY AUTOINCREMENT,vendedor TEXT,"
                + "cliente TEXT,oferta TEXT,cantidad INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        db.execSQL("DROP TABLE " + TABLE_OFERTA);
        db.execSQL("DROP TABLE " + TABLE_CARRITO);
        onCreate(db);
    }
}
