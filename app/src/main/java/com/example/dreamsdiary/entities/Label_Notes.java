package com.example.dreamsdiary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Label_Notes {

    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ForeignKey(entity = Notes.class,
            parentColumns = "id",
            childColumns = "noteId",
            onDelete = ForeignKey.CASCADE)
    public Long noteId;

    @ForeignKey(entity = Labels.class,
            parentColumns = "id",
            childColumns = "labelId",
            onDelete = ForeignKey.CASCADE)
    public Long labelId;
}
