package com.example.dreamsdiary.dao;

import android.arch.persistence.room.*;

import com.example.dreamsdiary.NewNoteFragments.LinearGraphicValues;
import com.example.dreamsdiary.entities.Notes;

import java.lang.reflect.Array;
import java.util.List;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes ORDER BY date")
    List<Notes> getAll();

    @Query("SELECT * FROM notes WHERE id = :id")
    Notes getById(int id);

    @Query("SELECT COUNT(notes.id) FROM notes")
    int countAll();

    @Query("SELECT COUNT(notes.id) FROM notes WHERE licuid = 1")
    int countLicuid();

    @Query("SELECT COUNT(notes.id) FROM notes WHERE favorite = 1")
    int countFavorite();

    @Query("SELECT * FROM notes WHERE favorite = 1")
    List<Notes> getFavorite();

    @Query("SELECT date || '=' || COUNT(id) AS result FROM notes WHERE date = (SELECT DISTINCT date FROM notes WHERE date BETWEEN date('now','-30 day') AND date('now'))")
    List<String> getCountNotesForMonth();

    @Query("SELECT DISTINCT date FROM notes WHERE date BETWEEN date('now','-30 day') AND date('now')")
    List<String> getDates();

    @Insert
    void insert(Notes notes);

    @Update
    void update(Notes notes);

    @Delete
    void delete(Notes notes);
}
