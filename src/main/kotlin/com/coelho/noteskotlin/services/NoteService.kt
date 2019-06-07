package com.coelho.noteskotlin.services;

import com.coelho.noteskotlin.models.Note
import java.util.*

interface NoteService {

    fun findById(id: Long): Optional<Note>

    fun findAll(): List<Note>

    fun create(note: Note): Note

    fun update(note: Note): Note

    fun delete(id: Long)
}
