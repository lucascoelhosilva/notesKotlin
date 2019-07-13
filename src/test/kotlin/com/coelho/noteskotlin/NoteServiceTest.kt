package com.coelho.noteskotlin

import com.coelho.noteskotlin.models.Note
import com.coelho.noteskotlin.services.NoteService
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [NoteskotlinApplication::class])
class NoteServiceTest {

    @Autowired
    lateinit var noteService: NoteService

    @Test
    fun createNoteSuccess() {
        val note = Note(title = "Note test", description = "description")

        val noteResult = noteService.create(note)

        assertEquals(note.title, noteResult.title)
        assertEquals(note.description, noteResult.description)
    }
}