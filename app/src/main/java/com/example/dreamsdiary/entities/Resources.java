package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Resources {

    @PrimaryKey(autoGenerate = true)
    public Long id;

    public String name;

    public String path;

    @ForeignKey(entity = Notes.class,
            parentColumns = "nt_id",
            childColumns = "rs_noteId",
            onDelete = ForeignKey.CASCADE)
    public Long noteId;
}
