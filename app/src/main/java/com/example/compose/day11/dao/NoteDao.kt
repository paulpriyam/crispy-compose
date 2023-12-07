package com.example.compose.day11.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.compose.day11.model.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * from note_table")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Query("SELECT * FROM note_table WHERE id=:id")
    suspend fun getNoteById(id: String): NoteModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)

    @Query("DELETE FROM note_table")
    suspend fun deleteAllNote()

}