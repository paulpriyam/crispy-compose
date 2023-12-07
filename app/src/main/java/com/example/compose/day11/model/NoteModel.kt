package com.example.compose.day11.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import java.util.UUID

@Entity(tableName = "note_table")
data class NoteModel(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val note: String,
    val date: Date = Date.from(Instant.now())
)
