package com.example.compose.day11.repository

import com.example.compose.day11.dao.NoteDao
import com.example.compose.day11.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun getAllNotes() = noteDao.getAllNotes().flowOn(Dispatchers.IO).conflate()

    suspend fun insertNote(note: NoteModel) = noteDao.insertNote(note)

    suspend fun getNoteById(id: String) = noteDao.getNoteById(id)

    suspend fun deleteAllNote() = noteDao.deleteAllNote()

    suspend fun deleteNoteById(note: NoteModel) = noteDao.deleteNote(note)
}