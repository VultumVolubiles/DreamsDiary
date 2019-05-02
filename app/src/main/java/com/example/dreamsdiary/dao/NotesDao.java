package com.example.dreamsdiary.dao;

import android.arch.persistence.room.*;
import com.example.dreamsdiary.entities.Notes;

import java.util.List;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM Notes")
    List<Notes> getAll();

    @Query("SELECT * FROM Notes WHERE id = :id")
    Notes getById(Long id);

    @Query("SELECT COUNT(id) FROM Notes")
    Long countAll();

    @Query("SELECT COUNT(id) FROM Notes WHERE licuid = 1")
    Long countLicuid();

    @Query("SELECT * FROM Notes WHERE favorite = 1")
    List<Notes> getFavorite();

    @Insert
    public void insert(Notes notes);

    @Update
    void update(Notes notes);

    @Delete
    void delete(Notes notes);
}
