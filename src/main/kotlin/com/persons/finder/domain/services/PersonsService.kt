package com.persons.finder.domain.services

import com.persons.finder.repository.model.PersonsEntity


interface PersonsService {
     fun getPersonById(id: Long): PersonsEntity
    fun save(person: PersonsEntity): PersonsEntity
}