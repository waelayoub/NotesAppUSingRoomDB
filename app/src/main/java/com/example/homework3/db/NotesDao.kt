package com.example.homework3.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.homework3.model.NotesItem


@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: NotesItem)

    @Delete
    fun delete(item: NotesItem)

    @Query("SELECT * FROM notes_items")
    fun getAllNotesItems(): LiveData<List<NotesItem>> // LiveData is a class that saves the data gotten by the DataBase To make reading faster using the keyword Observe
}