package com.example.compose.day11.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.compose.day11.viewmodel.NoteViewModel
import com.example.compose.ui.theme.ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteMyApp {
                val viewModel: NoteViewModel by viewModels()
                NoteScreen(viewModel.notes.collectAsState().value,
                    addNote = {
                        viewModel.addNote(it)
                    }, removeNote = {
                        viewModel.removeNote(it)
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