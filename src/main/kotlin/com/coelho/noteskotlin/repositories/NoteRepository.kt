package com.coelho.noteskotlin.repositories

import com.coelho.noteskotlin.models.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository: JpaRepository<Note, Long> {

}