package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Label_Notes {

    @PrimaryKey(autoGenerate = true)
    public int ln_id;

    @ForeignKey(entity = Notes.class,
            parentColumns = "nt_id",
            childColumns = "ln_noteId",
            onDelete = ForeignKey.CASCADE)
    public int ln_noteId;

    @ForeignKey(entity = Labels.class,
            parentColumns = "lb_id",
            childColumns = "ln_labelId",
            onDelete = ForeignKey.CASCADE)
    public int ln_labelId;
}
