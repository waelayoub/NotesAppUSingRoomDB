package com.example.homework3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homework3.repository.NotesRepository

class NotesViewModelFactory(private val repository: NotesRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(repository) as T
    }
}