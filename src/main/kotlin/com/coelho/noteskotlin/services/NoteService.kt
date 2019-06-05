package com.coelho.noteskotlin.services;

import com.coelho.noteskotlin.models.Note

interface NoteService {

    fun findById(id: Long): Note

    fun findAll(): List<Note>

    fun create(scenario: Note): Note

    fun update(scenario: Note): Note

    fun delete(id: Long)
}
