package com.coelho.noteskotlin.controllers

import com.coelho.noteskotlin.exceptions.NotFoundException
import com.coelho.noteskotlin.models.Note
import com.coelho.noteskotlin.services.NoteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Objects.nonNull

@RestController
@RequestMapping("/notes")
class NoteController(
        private val noteService: NoteService) {

    @GetMapping
    fun list(): ResponseEntity<List<Note>> {
        val allNotes = noteService.findAll()
        return ResponseEntity.ok(allNotes)
    }

    @PostMapping
    fun add(@RequestBody note: Note): ResponseEntity<Note> {
        val savedNote = noteService.create(note)
        return ResponseEntity.ok(savedNote)

    }

    @PutMapping("{id}")
    fun alter(@PathVariable id:Long, @RequestBody note: Note): ResponseEntity<Note> {
        if(nonNull(noteService.findById(id))){
            val noteUpdated = noteService.update(note)
            return ResponseEntity.ok(noteUpdated)
        }
        throw NotFoundException("Note not found")
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit>{
        if(nonNull(noteService.findById(id))){
            return ResponseEntity.ok().build()
        }
        throw NotFoundException("Note not found")
    }
}