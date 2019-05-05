package com.example.dreamsdiary.dao;

import android.arch.persistence.room.*;
import com.example.dreamsdiary.entities.Notes;

import java.util.List;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes")
    List<Notes> getAll();

    @Query("SELECT * FROM notes WHERE id = :id")
    Notes getById(int id);

    @Query("SELECT COUNT(notes.id) FROM notes")
    int countAll();

    @Query("SELECT COUNT(notes.id) FROM notes WHERE licuid = 1")
    int countLicuid();

    @Query("SELECT * FROM notes WHERE favorite = 1")
    List<Notes> getFavorite();

    @Insert
    void insert(Notes notes);

    @Update
    void update(Notes notes);

    @Delete
    void delete(Notes notes);
}
