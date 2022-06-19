package com.example.homework3.repository

import com.example.homework3.db.NotesDatabase
import com.example.homework3.model.NotesItem

class NotesRepository(private val db:NotesDatabase) {
    fun upsert(item: NotesItem) = db.getNotesDao().upsert(item)

    fun delete (item: NotesItem) = db.getNotesDao().delete(item)

    fun getAllNotesItems() = db.getNotesDao().getAllNotesItems()
}