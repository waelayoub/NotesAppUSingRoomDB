package com.example.homework3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework3.R
import androidx.lifecycle.Observer
import com.example.homework3.databinding.ActivityMainBinding
import com.example.homework3.db.NotesDatabase
import com.example.homework3.repository.NotesRepository
import com.example.homework3.ui.utils.NotesAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val database = NotesDatabase(this)
        val repository = NotesRepository(database)
        val factory = NotesViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(NotesViewModel::class.java)

        val notesAdapter = NotesAdapter(listOf(), viewModel)


        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.adapter = notesAdapter

        viewModel.getAllNotesItems().observe(this, Observer{ NotesItemsList ->
            notesAdapter.NotesList = NotesItemsList
            notesAdapter.notifyDataSetChanged()
        })

        binding.btnAddNotes.setOnClickListener {
            finish()
            val intent= Intent(this, NotesWriting::class.java)
            startActivity(intent)
        }
    }
}