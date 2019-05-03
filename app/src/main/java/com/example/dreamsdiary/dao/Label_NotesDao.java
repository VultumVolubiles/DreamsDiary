package com.example.dreamsdiary.dao;

import android.arch.persistence.room.*;
import com.example.dreamsdiary.entities.Label_Notes;
import com.example.dreamsdiary.entities.Labels;
import com.example.dreamsdiary.entities.Notes;

import java.util.List;

@Dao
public interface Label_NotesDao {

    @Query("SELECT * FROM Labels WHERE id = (SELECT labelId FROM Label_Notes WHERE noteId = :id)")
    Labels getAllLabelsForNote(int id);

    @Query("SELECT * FROM Notes WHERE id = (SELECT noteId FROM Label_Notes WHERE labelId = :id)")
    Notes getAllNotesForLabel(int id);

    @Insert
    void insert(Label_Notes label_notes);

    @Update
    void update(Label_Notes label_notes);

    @Delete
    void delete(Label_Notes label_notes);
}
