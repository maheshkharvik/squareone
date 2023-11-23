package com.persons.finder.presentation

import com.persons.finder.domain.services.PersonsData

class PersonsDTO
(
        val name: String?,
        val distance: Double,
) {
    companion object ModelMapper {
        fun from(personData: PersonsData): PersonsDTO {
            return PersonsDTO(
                    name = personData.name,
                    distance = personData.distance
                                       )
        }
    }
}