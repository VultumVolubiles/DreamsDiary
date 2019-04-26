package com.example.dreamsdiary.dao;

import android.arch.persistence.room.*;
import com.example.dreamsdiary.entities.Label_Notes;
import com.example.dreamsdiary.entities.Labels;
import com.example.dreamsdiary.entities.Notes;

import java.util.List;

@Dao
public interface Label_NotesDao {

    @Query("SELECT * FROM Labels WHERE lb_id = (SELECT ln_labelId FROM Label_Notes WHERE ln_noteId = :nt_id)")
    Labels getAllLabelsForNote(int nt_id);

    @Query("SELECT * FROM Notes WHERE nt_id = (SELECT ln_noteId FROM Label_Notes WHERE ln_labelId = :lb_id)")
    Notes getAllNotesForLabel(int lb_id);

    @Insert
    void insert(Label_Notes label_notes);

    @Update
    void update(Label_Notes label_notes);

    @Delete
    void delete(Label_Notes label_notes);
}
