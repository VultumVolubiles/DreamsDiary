package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public int nt_id;

    public String nt_title;

    public String nt_body;

    public String nt_date;

    public String nt_time;

    public String nt_color;

    public boolean nt_favorite;

    public boolean nt_licuid;
}
