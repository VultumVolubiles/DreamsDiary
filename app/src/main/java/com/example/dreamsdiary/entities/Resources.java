package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Resources {

    @PrimaryKey(autoGenerate = true)
    public int rs_id;

    public String rs_name;

    public String rs_path;

    @ForeignKey(entity = Notes.class,
            parentColumns = "nt_id",
            childColumns = "rs_noteId",
            onDelete = ForeignKey.CASCADE)
    public int rs_noteId;
}
