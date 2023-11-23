package com.persons.finder.domain.services

import com.persons.finder.repository.PersonRepository
import com.persons.finder.repository.model.PersonsEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PersonsServiceImpl :PersonsService {


    @Autowired
    private val personRepository: PersonRepository? = null

    override fun getPersonById(id: Long): PersonsEntity {
        return personRepository!!.getReferenceById(id)
    }

    override fun save(person: PersonsEntity) : PersonsEntity = personRepository!!.save(person)

}