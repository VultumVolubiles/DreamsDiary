package com.example.dreamsdiary.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(tableName = "notes")
public class Notes implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "body")
    public String body;

    @NonNull
    @ColumnInfo(name = "date")
    public String date; // Тип Date выдаёт ошибку т.к. Room не может конвертировать такой тип данных в SQLite

    @NonNull
    @ColumnInfo(name = "color")
    public String color;

    @NonNull
    @ColumnInfo(name = "favorite")
    public int favorite;

    @NonNull
    @ColumnInfo(name = "licuid")
    public int licuid;


    public Notes() {
//        this.id = 1;
        this.title = "";
        this.body = "";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.date = format.format(date);
        this.color = "#DCD3D3";
        this.favorite = 0;
        this.licuid = 0;
    }
    public Notes(String title, String body, Date date, String color, int favorite, int licuid) {
        this.title = title;
        this.body = body;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.date = format.format(date);
        this.color = color;
        this.favorite = favorite;
        this.licuid = licuid;
    }
}
