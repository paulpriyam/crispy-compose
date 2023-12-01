package com.example.compose.day11.component

import android.graphics.Color
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteTextField(
    modifier: Modifier = Modifier,
    value: MutableState<String>,
    label: String,
    imeAction: ImeAction,
    onChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = modifier.padding(horizontal = 16.dp), value = value.value, onValueChange = {
            value.value = it
            onChange.invoke(value.value)
        },
        label = { Text(text = label) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = androidx.compose.ui.graphics.Color.White),
        keyboardOptions = KeyboardOptions(imeAction = imeAction),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        })
    )
}