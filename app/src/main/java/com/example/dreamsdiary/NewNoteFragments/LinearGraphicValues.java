package com.example.dreamsdiary.NewNoteFragments;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class LinearGraphicValues {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String date;

    @NonNull
    public Integer count;

    public LinearGraphicValues(String date, int count) {
        this.date = date;
        this.count = count;
    }
}
