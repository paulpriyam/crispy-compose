package com.example.compose.day11.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.day11.model.NoteModel
import com.example.compose.day11.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    private val _notes = MutableStateFlow<List<NoteModel>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        getAllNotes()
    }

    fun addNote(note: NoteModel) = viewModelScope.launch { repository.insertNote(note) }

    fun removeNote(note: NoteModel) = viewModelScope.launch { repository.deleteNoteById(note) }

    fun removeAllNotes() = viewModelScope.launch { repository.deleteAllNote() }

    fun getAllNotes() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllNotes()
            .distinctUntilChanged()
            .collect {
                _notes.value = it
            }
    }
}