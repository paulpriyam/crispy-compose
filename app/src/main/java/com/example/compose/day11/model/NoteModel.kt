package com.example.compose.day11.model

import java.time.Clock
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import java.util.UUID

data class NoteModel(
    val id:UUID= UUID.randomUUID(),
    val title:String,
    val note:String,
    val date:LocalDateTime= LocalDateTime.now()
)
