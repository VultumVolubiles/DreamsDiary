package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;

    public String body;

    public String date; // Тип Date выдаёт ошибку т.к. Room не может конвертировать такой тип данных в SQLite

    public String color;

    public int favorite;

    public int licuid;
}
