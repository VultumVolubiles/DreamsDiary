package com.example.dreamsdiary.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;
import com.example.dreamsdiary.entities.Resources;

@Dao
public interface ResourcesDao {
    @Insert
    void insert(Resources res);

    @Update
    void update(Resources res);

    @Delete
    void delete(Resources res);
}
