package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public Long id;

    public String title;

    public String body;

    public Date date;

    public String color;

    public Long favorite;

    public Long licuid;
}
