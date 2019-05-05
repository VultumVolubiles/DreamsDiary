package com.example.dreamsdiary.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "label_notes")
public class Label_Notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ForeignKey(entity = Notes.class,
            parentColumns = "id",
            childColumns = "noteId",
            onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "noteId")
    public int noteId;

    @ForeignKey(entity = Labels.class,
            parentColumns = "id",
            childColumns = "labelId",
            onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "labelId")
    public int labelId;
}
