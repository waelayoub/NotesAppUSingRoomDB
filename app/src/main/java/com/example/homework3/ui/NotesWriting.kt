package com.example.homework3.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.homework3.R
import com.example.homework3.databinding.ActivityNotesWritingBinding
import com.example.homework3.db.NotesDatabase
import com.example.homework3.model.NotesItem
import com.example.homework3.repository.NotesRepository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NotesWriting : AppCompatActivity() {
    private lateinit var binding: ActivityNotesWritingBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityNotesWritingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formatted = current.format(formatter)
        binding.tvDate.text=formatted



        val database = NotesDatabase(this)
        val repository = NotesRepository(database)
        val factory = NotesViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(NotesViewModel::class.java)

        binding.btnSaveNotes.setOnClickListener {
            val notesTitle = binding.etTitle.text.toString()
            val notesContent = binding.etNote.text.toString()
            val notesDate = binding.tvDate.text.toString()

            if (notesTitle.isEmpty() || notesContent.isEmpty()){
                Toast.makeText(this,"Please write title and Note", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var item = NotesItem(notesTitle,notesContent,notesDate)
            viewModel.upsert(item)
            finish()
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            }
        }
    }

