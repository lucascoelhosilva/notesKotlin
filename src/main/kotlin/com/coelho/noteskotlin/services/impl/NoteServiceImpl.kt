package com.coelho.noteskotlin.services.impl

import com.coelho.noteskotlin.models.Note
import com.coelho.noteskotlin.repositories.NoteRepository
import com.coelho.noteskotlin.services.NoteService
import org.springframework.stereotype.Service

@Service
class NoteServiceImpl(
        val noteRepository: NoteRepository
) : NoteService {

    override fun findAll(): List<Note> {
        return noteRepository.listAll()
    }

    override fun findById(id: Long): Note {
        return noteRepository.findById(id = id)!!
    }

    override fun create(note: Note): Note {
        noteRepository.persist(note)
        return  note
    }

    override fun update(note: Note): Note {
        noteRepository.persist(note)
        return note
    }

    override fun delete(id: Long) {
        noteRepository.delete(id)
    }
}