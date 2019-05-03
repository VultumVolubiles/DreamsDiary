package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Labels {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
}