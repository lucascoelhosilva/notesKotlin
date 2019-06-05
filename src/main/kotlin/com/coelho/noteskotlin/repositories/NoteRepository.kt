package com.coelho.noteskotlin.repositories

import com.coelho.noteskotlin.models.Note
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class NoteRepository: IBaseRepository<Note, Long>{

    @Autowired
    internal var em: EntityManager? = null

    override val clazz: Class<Note>
        get() = Note::class.java

    override val entityManager: EntityManager?
        get() = em
}