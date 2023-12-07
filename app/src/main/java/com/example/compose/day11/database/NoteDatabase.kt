package com.example.compose.day11.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.compose.day11.converters.DateConverter
import com.example.compose.day11.converters.UUIDConverter
import com.example.compose.day11.dao.NoteDao
import com.example.compose.day11.model.NoteModel

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
@TypeConverters(UUIDConverter::class, DateConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}