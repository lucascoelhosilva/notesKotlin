package com.coelho.noteskotlin.services

import com.coelho.noteskotlin.models.Note
import com.coelho.noteskotlin.repositories.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService (private val noteRepository: NoteRepository){

    fun all() : List<Note>{
        return noteRepository.findAll().toList()
    }

    fun deleteById(id: Long){
        noteRepository.deleteById(id)
    }

    fun existsById(id: Long): Boolean {
        return noteRepository.existsById(id)
    }

    fun save(note: Note): Note {
        return noteRepository.save(note)
    }

    fun alter(id: Long, note: Note): Note {
        val safeNote = note.copy(id = id)
        return noteRepository.save(safeNote)
    }
}