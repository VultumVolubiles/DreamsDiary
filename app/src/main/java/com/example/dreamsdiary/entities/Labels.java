package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Labels {

    @PrimaryKey(autoGenerate = true)
    public int lb_id;

    public String lb_name;
}