package com.coelho.noteskotlin.repositories

import javax.persistence.EntityManager
import javax.transaction.Transactional

interface IBaseRepository<T, ID> {

    val clazz: Class<T>

    val entityManager: EntityManager?

    @Transactional
    fun persist(entity: T) {
        entityManager?.persist(entity)
    }

    fun findById(id: ID): T? {
        return entityManager?.find(clazz, id)
    }

    operator fun contains(id: ID): Boolean {
        return findById(id) != null
    }

    @Transactional
    fun delete(id: ID) {
        val entity = findById(id)
        entityManager?.remove(entity)
    }

    fun listAll(): List<T> {
        return entityManager?.createQuery("SELECT e FROM " + this.clazz.simpleName + " as e", clazz)?.resultList as List<T>
    }
}