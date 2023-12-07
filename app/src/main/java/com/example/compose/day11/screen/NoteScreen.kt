package com.example.compose.day11.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.day11.component.NoteTextField
import com.example.compose.day11.model.NoteModel
import com.example.compose.day11.util.formatDate

@Preview
@Composable
fun NoteScreen(
    notes: List<NoteModel> = emptyList(),
    addNote: (NoteModel) -> Unit = {},
    removeNote: (NoteModel) -> Unit = {}
) {
    val noteTitleState = remember {
        mutableStateOf("")
    }
    val noteState = remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row() {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "NoteScreen",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    ), textAlign = TextAlign.Center
                )
            }
        }

    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteTextField(
                modifier = Modifier.fillMaxWidth(),
                value = noteTitleState,
                label = "Title",
                imeAction = ImeAction.Next
            ) {
                noteTitleState.value = it
            }
            Spacer(modifier = Modifier.height(16.dp))
            NoteTextField(
                modifier = Modifier.fillMaxWidth(),
                value = noteState,
                label = "Add Note",
                imeAction = ImeAction.Done
            ) {
                noteState.value = it
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (noteTitleState.value.isNotEmpty() && noteState.value.isNotEmpty()) {
                    addNote.invoke(NoteModel(title = noteTitleState.value, note = noteState.value))
                    noteState.value = ""
                    noteTitleState.value = ""
                }
            }) {
                Text(text = "Save")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
            if (notes.isEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Pls add notes..",
                    style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.empty_list), contentDescription = "empty list")
            } else {
                LazyColumn {
                    items(items = notes) { item ->
                        NoteRowItem(item) {
                            removeNote.invoke(it)
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun NoteRowItem(
    item: NoteModel = NoteModel(
        title = "A Movie Day",
        note = "This is a nice movie",
    ),
    removeNote: (NoteModel) -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                removeNote.invoke(item)
            },
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 16.dp,
            bottomEnd = 0.dp,
            bottomStart = 16.dp
        ),
        color = Color.LightGray,
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = item.title, style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = item.note, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.date.formatDate(),
                style = MaterialTheme.typography.body1
            )
        }
    }

}