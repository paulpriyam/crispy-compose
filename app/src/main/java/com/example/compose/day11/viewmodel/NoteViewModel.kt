package com.example.compose.day11.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.compose.day11.model.NoteModel

class NoteViewModel : ViewModel() {
    private val notes = mutableStateListOf<NoteModel>()

    fun addNote(note: NoteModel) {
        notes.add(note)
    }

    fun removeNote(note: NoteModel) {
        notes.remove(note)
    }

    fun getAllNotes() = notes
}