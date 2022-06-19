package com.example.homework3.ui.utils

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.databinding.NotesItemsLayout1Binding
import com.example.homework3.model.NotesItem
import com.example.homework3.ui.NotesViewModel

class NotesAdapter(var NotesList:List<NotesItem>,private val viewModel: NotesViewModel) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    inner class NotesViewHolder(val binding: NotesItemsLayout1Binding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            NotesItemsLayout1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        var theNote:String=""
        theNote+=NotesList[position].title
        theNote+="\n"
        theNote+=NotesList[position].Note
        holder.binding.tvTheNote.text=theNote
        holder.binding.tvNotesDate.text=NotesList[position].currentDate

        holder.binding.btnDeleteNote.setOnClickListener {
            viewModel.delete(NotesList[position])
        }
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }
}
