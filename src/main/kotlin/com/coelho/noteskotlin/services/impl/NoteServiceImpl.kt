package com.coelho.noteskotlin.services.impl

import com.coelho.noteskotlin.models.Note
import com.coelho.noteskotlin.repositories.NoteRepository
import com.coelho.noteskotlin.services.NoteService
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteServiceImpl(
        val noteRepository: NoteRepository
) : NoteService {

    override fun findAll(): List<Note> {
        return noteRepository.findAll()
    }

    override fun findById(id: Long): Optional<Note> {
        return noteRepository.findById(id)
    }

    override fun create(note: Note): Note {
        noteRepository.saveAndFlush(note)
        return  note
    }

    override fun update(note: Note): Note {
        noteRepository.saveAndFlush(note)
        return note
    }

    override fun delete(id: Long) {
        noteRepository.deleteById(id)
    }
}