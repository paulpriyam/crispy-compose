package com.example.compose.day11.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.compose.day11.model.NoteModel
import com.example.compose.ui.theme.ComposeTheme

class NoteScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteMyApp {
                val notes = remember {
                    mutableStateListOf<NoteModel>()
                }
                NoteScreen(notes, addNote = {
                    notes.add(it)
                }, removeNote = {
                    notes.remove(it)
                })
            }
        }
    }
}

@Composable
fun NoteMyApp(content: @Composable () -> Unit) {
    ComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}