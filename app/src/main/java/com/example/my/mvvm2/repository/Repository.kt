package com.example.my.mvvm2.repository

import com.example.my.mvvm2.room.Note
import com.example.my.mvvm2.room.NotesDatabaseImpl
import kotlinx.coroutines.flow.Flow

class Repository(
    private val db: NotesDatabaseImpl
)
{
    private val dao get() = db.notesDao

    fun getAll(): Flow<List<Note>> = dao.getAll()

    suspend fun save(note: Note) = dao.add(note)

    suspend fun delete(note: Note) = dao.delete(note)
}