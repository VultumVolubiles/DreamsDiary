package com.example.dreamsdiary.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "resources")
public class Resources {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "path")
    public String path;

    @ForeignKey(entity = Notes.class,
            parentColumns = "nt_id",
            childColumns = "rs_noteId",
            onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "noteId")
    public int noteId;
}
