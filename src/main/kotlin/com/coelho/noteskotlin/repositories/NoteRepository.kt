package com.coelho.noteskotlin.repositories

import com.coelho.noteskotlin.models.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, Long>