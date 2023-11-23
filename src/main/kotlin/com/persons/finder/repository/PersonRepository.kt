package com.persons.finder.repository

import com.persons.finder.repository.model.PersonsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<PersonsEntity, Long>