package com.example.homework3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_items")
data class NotesItem(
    @ColumnInfo(name = "Item_Title")
    val title:String,

    @ColumnInfo(name = "Item_Content")
    val Note:String,

    @ColumnInfo(name = "Item_Date")
    val currentDate: String)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}