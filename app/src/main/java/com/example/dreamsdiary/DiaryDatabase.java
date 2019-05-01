package com.example.dreamsdiary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import com.example.dreamsdiary.dao.Label_NotesDao;
import com.example.dreamsdiary.dao.LabelsDao;
import com.example.dreamsdiary.dao.NotesDao;
import com.example.dreamsdiary.dao.ResourcesDao;
import com.example.dreamsdiary.entities.Label_Notes;
import com.example.dreamsdiary.entities.Labels;
import com.example.dreamsdiary.entities.Notes;
import com.example.dreamsdiary.entities.Resources;

@Database(entities = {Notes.class, Labels.class, Label_Notes.class, Resources.class}, version = 1, exportSchema = false)
public abstract class DiaryDatabase extends RoomDatabase {
    public abstract NotesDao notesDao();
    public abstract LabelsDao labelsDao();
    public abstract Label_NotesDao label_notesDao();
    public abstract ResourcesDao resourcesDaoDao();
}


