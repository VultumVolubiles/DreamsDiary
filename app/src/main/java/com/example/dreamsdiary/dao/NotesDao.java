package com.example.dreamsdiary.dao;

import android.arch.persistence.room.*;
import com.example.dreamsdiary.entities.Notes;

import java.util.List;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM Notes")
    List<Notes> getAll();

    @Query("SELECT * FROM Notes WHERE nt_id = :id")
    Notes getById(int id);

    @Query("SELECT COUNT(nt_id) FROM Notes")
    int countAll();

    @Query("SELECT COUNT(nt_id) FROM Notes WHERE nt_licuid = 1")
    int countLicuid();

    @Query("SELECT * FROM Notes WHERE nt_favorite = 1")
    List<Notes> getFavorite();

    @Insert
    void insert(Notes notes);

    @Update
    void update(Notes notes);

    @Delete
    void delete(Notes notes);
}
