package com.example.homework3.ui

import androidx.lifecycle.ViewModel
import com.example.homework3.model.NotesItem
import com.example.homework3.repository.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository):ViewModel() {
    fun upsert(item: NotesItem)= CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun delete(item: NotesItem)= CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    fun getAllNotesItems()= repository.getAllNotesItems()
}