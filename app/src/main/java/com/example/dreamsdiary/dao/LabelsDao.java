package com.example.dreamsdiary.dao;

import android.arch.persistence.room.*;
import com.example.dreamsdiary.entities.Labels;

import java.util.List;

@Dao
public interface LabelsDao {

    @Query("SELECT * FROM labels")
    List<Labels> getAll();

    @Insert
    void insert(Labels label);

    @Update
    void update(Labels label);

    @Delete
    void delete(Labels label);
}
