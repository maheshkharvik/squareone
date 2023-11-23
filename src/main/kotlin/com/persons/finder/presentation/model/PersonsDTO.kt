package com.persons.finder.presentation.model

import com.persons.finder.domain.services.model.PersonsData

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