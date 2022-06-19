package com.example.homework3.db

import android.content.Context
import androidx.room.*
import com.example.homework3.model.NotesItem

@Database(
    entities = [NotesItem::class],
    version = 1
    )
abstract class NotesDatabase :RoomDatabase(){
    abstract fun getNotesDao():NotesDao
    companion object{
        @Volatile
        private var instant:NotesDatabase?=null
        private val LOCK = Any()
        operator fun invoke(context: Context)= instant ?: synchronized(LOCK){ // synchronise to check if instance exist
            instant?: createDatabase(context).also { // if instance null create db
                instant=it // we used also to use the it (which is the return of createDatabase) to put it in instant to not duplicate later on
            }
    }

        private fun createDatabase(context:Context)=
            Room.databaseBuilder(context.applicationContext, NotesDatabase::class.java, "NotesDB.db").build()
    }
}